package com.xzy.microweathereurekaclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * create by: xzy
 * description:
 * create time: 22:14 2018/11/24
 *
 * @Param 
 * @return 
 */
@FeignClient("msa-weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
