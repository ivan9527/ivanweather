package com.example.ivanweather.util;

import android.text.TextUtils;

import com.example.ivanweather.db.City;
import com.example.ivanweather.db.County;
import com.example.ivanweather.db.FollowCounty;
import com.example.ivanweather.db.Province;
import com.example.ivanweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){

            try {

                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response , int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i =0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response , int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i =0;i<allCounties.length();i++){
                    JSONObject cityObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(cityObject.getString("name"));
                    county.setWeatherId(cityObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * 保存关注的数据
     */
    public static boolean handleFollowResponse(String countyName , int cityId ,String weatherId){

       if(!countyName.isEmpty() && !weatherId.isEmpty() & cityId!=0){
           FollowCounty followCounty = new FollowCounty();
           followCounty.setCountyName(countyName);
           followCounty.setWeatherId(weatherId);
           followCounty.setCityId(cityId);
           followCounty.save();
           return true;
       }

        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray array = jsonObject.getJSONArray("HeWeather");
            String weatherContent = array.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
