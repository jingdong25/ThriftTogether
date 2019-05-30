package com.pro516.thrifttogether.ui.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.pro516.thrifttogether.entity.ResponseMessageEntity;
import com.pro516.thrifttogether.entity.mall.MallBean;
import com.pro516.thrifttogether.entity.mine.CollectedProductVO;
import com.pro516.thrifttogether.entity.mine.CollectedShopVO;
import com.pro516.thrifttogether.entity.mine.OrderBean;
import com.pro516.thrifttogether.entity.mine.ShopBean;
import com.pro516.thrifttogether.entity.mine.VoucherPackageBean;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hncboy on 2019-05-07.
 */
public class JsonParser {

    private static final Gson mGson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return new Date(json.getAsJsonPrimitive().getAsLong());
        }
    }).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static ArrayList<ShopBean> dailyRecommendation(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<ShopBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<ShopBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }

    }

    public static ArrayList<ShopBean> lookAround(String json) {
        Type token = new TypeToken<ArrayList<ShopBean>>() {
        }.getType();
        return mGson.fromJson(json, token);
    }

    public static ArrayList<MallBean> VoucherPackage(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<MallBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<MallBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<CollectedShopVO> collectionShopList(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<CollectedShopVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<CollectedShopVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<CollectedProductVO> collectionProductList(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<CollectedProductVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<CollectedProductVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<OrderBean> Orders(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<OrderBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<OrderBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static boolean updateOrders(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<OrderBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<OrderBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return true;
        } else {
            return false;
        }
    }

}
