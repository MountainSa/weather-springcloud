package com.xzy.spring.cloud.weather.controller;

import com.xzy.spring.cloud.weather.service.DataClient;
import com.xzy.spring.cloud.weather.service.WeatherReportService;
import com.xzy.spring.cloud.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName WeatherReportController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/17 0:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private DataClient dataClient;
    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        //todo  改为由城市数据api微服务提供数据
        //TODO 改为城市数据api服务提供数据
        List<City> cityList = null;
        try {
            cityList = dataClient.listCity();
        } catch (Exception e) {
           LOGGER.error("exception",e);
        }
        model.addAttribute("title", "肖曾永的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
