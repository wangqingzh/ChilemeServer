package com.wangqing.chilemeserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 映射静态文件
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Value("${file-path}")
    String filePath;
    @Value("${image-path}")
    String imagePath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imagePath).addResourceLocations("file:///" + filePath);
    }
}
