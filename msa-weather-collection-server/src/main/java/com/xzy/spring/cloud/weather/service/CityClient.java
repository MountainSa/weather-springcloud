package com.xzy.spring.cloud.weather.service;

import com.xzy.spring.cloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
/**
 * create by: xzy
 * description:
 * create time: 17:08 2018/11/25
 *
 * @Param 
 * @return 
 */
@FeignClient(value = "msa-weather-city-server")
public interface CityClient {

    @GetMapping("cities")
    List<City> listCity() throws Exception;

}
