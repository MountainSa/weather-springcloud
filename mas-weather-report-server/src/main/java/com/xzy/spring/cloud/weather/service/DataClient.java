package com.xzy.spring.cloud.weather.service;

import com.xzy.spring.cloud.weather.vo.City;
import com.xzy.spring.cloud.weather.vo.Weather;
import com.xzy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * create by: xzy
 * description:
 * create time: 22:26 2018/11/30
 *
 * @Param 
 * @return 
 */
@FeignClient("micro-weather-eureka-client")
public interface DataClient {
    /**
     * create by: xzy
     * description:获取城市列表
     * create time: 22:27 2018/11/30
     *
     * @Param 
     * @return 
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * create by: xzy
     * description:根据城市id查询天气数据
     * create time: 22:28 2018/11/30
     *
     * @Param 
     * @return 
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
