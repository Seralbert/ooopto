package ys.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by User on 28.11.2019.
 * Конфиг ресурсов
 */
public class MvcConfig implements WebMvcConfigurer {
    @Value("@{upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/docs/**").addResourceLocations("file:///"+uploadPath+"/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
