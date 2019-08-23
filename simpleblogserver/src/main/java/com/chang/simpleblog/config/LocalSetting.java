package com.chang.simpleblog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: chang.tong
 * @Date: 2019/8/23 16:55
 * @Version 1.0
 */
@Configuration
public class LocalSetting {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalSetting.class);
    private static Properties settings = new Properties();

    @Bean
    public void aa() throws Exception {
        LOGGER.info("开始初始化加载本地资源文件");
            try {
                FileReader fileReader = new FileReader("classpath:local.properties");
                if(fileReader != null){
                     settings.load(fileReader);
                     LOGGER.info("加载本地资源文件完成");
                } else{
                    LOGGER.warn("load LocalSetting failed!");
                }
            }catch (FileNotFoundException ex){
                LOGGER.warn("local.properties not found,load LocalSetting failed!",ex);
            }catch (IOException ex){
                LOGGER.warn("load LocalSetting failed!", ex);
            }

    }

    public static String getSetting(String name) {
        return settings.getProperty(name, "");
    }

    public static String getSetting(String name, String dv) {
        return settings.getProperty(name, dv);
    }

    public static boolean getSettingAsBoolean(String name, boolean dv) {
        boolean result = dv;
        try {
            result = Boolean.valueOf(settings.getProperty(name, String.valueOf(dv)));
        } catch (Exception ex) {
            LOGGER.error("message", ex);
        }
        return result;
    }

    public static int getSettingAsInteger(String name, int dv) {
        int result = dv;
        try {
            result = Integer.valueOf(settings.getProperty(name, String.valueOf(dv)));
        } catch (Exception ex) {
            LOGGER.error("message", ex);
        }
        return result;
    }
}
