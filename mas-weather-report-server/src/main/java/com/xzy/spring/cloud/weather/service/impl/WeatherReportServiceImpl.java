package com.xzy.spring.cloud.weather.service.impl;

import com.xzy.spring.cloud.weather.service.WeatherClient;
import com.xzy.spring.cloud.weather.service.WeatherReportService;
import com.xzy.spring.cloud.weather.vo.Weather;
import com.xzy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName WeatherReportServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/17 0:41
 * @Version 1.0
 **/
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    public WeatherClient weatherClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherClient.getDataByCityId(cityId);
        Weather data = resp.getData();
        return data;
    }
}
