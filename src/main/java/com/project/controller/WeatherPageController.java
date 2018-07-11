package com.project.controller;

import com.project.model.City;
import com.project.service.WeatherAppService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherPageController {

    private static final Logger logger = LogManager.getLogger(WeatherPageController.class);

    @Autowired
    private WeatherAppService weatherAppService;

    @GetMapping
    public String getPage(){
        return "weather-section/weather-main";
    }

    @RequestMapping(value = "/getlocal", method = RequestMethod.GET)
    @ResponseBody
    public List<City> getCity(@RequestParam(value="cityChar",required = false, defaultValue = "Sze") String cityName) throws IOException {
        return weatherAppService.getLocationByCityName(cityName);
    }

    @RequestMapping(value = "/getWeather", method = RequestMethod.GET)
    public String getWeather(@RequestParam(value="cityName", required = false) String cityName, Model model) throws IOException {
        model.addAttribute("weather1",weatherAppService.getApixuWeatherByCityName(cityName));
        model.addAttribute("weather2",weatherAppService.getOpenWeatherByCityName(cityName));
        model.addAttribute("differenceMap",weatherAppService.getDifferencesTwoObject());
        return "weather-section/weather-main";
    }
}

