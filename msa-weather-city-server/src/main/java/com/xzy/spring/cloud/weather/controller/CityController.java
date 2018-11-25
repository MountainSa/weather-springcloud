package com.xzy.spring.cloud.weather.controller;

import com.xzy.spring.cloud.weather.service.CityDataService;
import com.xzy.spring.cloud.weather.vo.City;
import com.xzy.spring.cloud.weather.vo.CityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CityController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/24 17:52
 * @Version 1.0
 **/
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCitys() throws Exception {
        List<City> cities = cityDataService.listCity();
        return cities;
    }
}
