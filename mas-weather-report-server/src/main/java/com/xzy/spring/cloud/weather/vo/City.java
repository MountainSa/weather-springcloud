package com.xzy.spring.cloud.weather.vo;

/**
 * @ClassName City
 * @Description TODO
 * @Author Administrator
 * @Date 2018/10/22 21:57
 * @Version 1.0
 **/
public class City{


    private String cityId;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    private String cityName;
    private String cityCode;
    private String province;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
