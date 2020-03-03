package com.example.ivanweather.db;

import org.litepal.crud.DataSupport;

/**
 * @创建者 ivan
 * @创建时间2020/3/2 10:45 PM
 * @描述 用户关注的地区列表
 */
public class FollowCounty extends DataSupport {

    private int id;

    private String countyName;

    private String weatherId;

    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
