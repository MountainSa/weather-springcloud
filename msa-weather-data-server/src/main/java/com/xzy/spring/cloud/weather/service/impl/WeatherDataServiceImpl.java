package com.xzy.spring.cloud.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzy.spring.cloud.weather.service.WeatherDataService;
import com.xzy.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * WeatherDataService 实现.
 *
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final Logger logger  = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        String key = uri;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //先查缓存，缓存有取缓存的数据
        if(stringRedisTemplate.hasKey(key)){
            logger.info("redis has data");
            strBody = ops.get(key);
        }else{
            logger.info("redis don't has data");
            //缓存没有抛出异常
            throw new RuntimeException("don't has data");
        }

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("error",e);
        }

        return resp;
    }

}
