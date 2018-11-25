package com.xzy.spring.cloud.weather.vo;

import lombok.Data;

/**
 * @ClassName City
 * @Description TODO
 * @Author Administrator
 * @Date 2018/10/22 21:57
 * @Version 1.0
 **/
@Data
public class City{


    private String cityId;
    private String cityName;
    private String cityCode;
    private String province;

}
