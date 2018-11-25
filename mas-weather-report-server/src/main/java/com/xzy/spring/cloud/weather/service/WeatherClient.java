package com.xzy.spring.cloud.weather.service;

import com.xzy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * create by: xzy
 * description:
 * create time: 17:11 2018/11/25
 *
 * @Param 
 * @return 
 */
@FeignClient(value = "msa-weather-data-server")
public interface WeatherClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
