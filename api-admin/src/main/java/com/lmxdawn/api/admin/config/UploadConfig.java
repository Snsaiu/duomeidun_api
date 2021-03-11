package com.lmxdawn.api.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/image/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/image/");
        registry.addResourceHandler("/api/video/**").addResourceLocations("file:"+System.getProperty("user.dir")+"/video/");
    }
}
