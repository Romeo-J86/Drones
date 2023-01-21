package com.drones.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Romeo Jerenyama
 * @created 20/01/2023 - 19:41
 */
@Configuration
public class BeanConfig{
    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}
}