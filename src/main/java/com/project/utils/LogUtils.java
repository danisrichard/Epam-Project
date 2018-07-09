package com.project.utils;

import com.google.gson.Gson;
import com.project.entity.LoggerInformation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Optional;

@Component
public class LogUtils {

    public String getLevelInformationInJson(String packageName) throws IllegalArgumentException {
        if (packageName == null) throw new IllegalArgumentException("Not valid input");
        Logger log = LogManager.getLogger(packageName);

        return new Gson().toJson(getLoggerInformation(log.getName(), log.getLevel().name()));
    }

    public String setCustomLogLevel(String logLevel, String packageName) throws IllegalArgumentException {
        if (checkInputs(logLevel, packageName)) throw new IllegalArgumentException("Not valid input!");

        Level concreteLevel = getConcreteLevel(logLevel);

        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration conf = ctx.getConfiguration();
        conf.getLoggerConfig(packageName).setLevel(concreteLevel);
        ctx.updateLoggers(conf);

        return getLevelInformationInJson(packageName);
    }

    private LoggerInformation getLoggerInformation(String packageName, String s) {
        return new LoggerInformation.Builder()
                .withLevelName(s)
                .withPackageName(packageName)
                .build();
    }

    @NotNull
    private Level getConcreteLevel(String logLevel) throws NullPointerException{
        Level[] levels = Level.values();

        Optional<Level> optionalLevel = Arrays.stream(levels).filter(e -> e.name().equalsIgnoreCase(logLevel)).findFirst();

        return optionalLevel.get();
    }

    private boolean checkInputs(String logLevel, String packageName) {
        return logLevel == null && packageName == null;
    }
}
