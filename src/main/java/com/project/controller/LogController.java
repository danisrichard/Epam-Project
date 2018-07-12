package com.project.controller;

import com.project.utils.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config/loglevel")
public class LogController {

    private static final Logger logger = LogManager.getLogger(LogController.class);

    @Autowired
    private LogUtils logUtils;

    @RequestMapping(value = "/get{packageName}", method = RequestMethod.GET)
    public String getLogLevelByPackage(@RequestParam(value = "packageName", required = false) String packageName){
        return logUtils.getLevelInformationInJson(packageName);
    }

    @RequestMapping(value = "/set{packageName}{levelName}", method = RequestMethod.GET)
    public String setLogLevelToPackage(@RequestParam(value = "packageName", required = false) String packageName,
                                       @RequestParam(value = "levelName", required = false) String levelName){
        return logUtils.setCustomLogLevel(levelName, packageName);
    }
}
