package com.xzy.microweathereurekaclient.controller;

import com.xzy.microweathereurekaclient.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CityController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/24 22:17
 * @Version 1.0
 **/
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("cities")
    public String listCity(){
        return cityClient.listCity();
    }

}
