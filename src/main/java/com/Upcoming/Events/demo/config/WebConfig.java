package com.Upcoming.Events.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override

    public void addCorsMappings(CorsRegistry registry){
        registry
        .addMapping("/**")
        .allowedOrigins("http://localhost:9001")
        .allowCredentials(true)
        .allowedMethods("GET", "POST", "DELETE", "OPTION", "PUT");
    }



@Override
     public void addResourceHandlers(ResourceHandlerRegistry registry){

         registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");


        if(!registry.hasMappingForPattern("/**")){

            
                    registry.addResourceHandler("/**")
                        .addResourceLocations("classpath:/*");

        }

    }

}