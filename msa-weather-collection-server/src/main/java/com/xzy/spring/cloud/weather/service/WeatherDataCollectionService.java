package com.xzy.spring.cloud.weather.service;
/**
 * create by: xzy
 * description:weather data collection service  天气采集服务
 * create time: 16:31 2018/11/24
 *
 * @Param 
 * @return 
 */
public interface WeatherDataCollectionService {

    /**
     * create by: xzy
     * description:根据城市id同步天气
     * create time: 16:33 2018/11/24
     *
     * @Param 
     * @return 
     */
    void sysncDataByCityId(String cityId);
}
