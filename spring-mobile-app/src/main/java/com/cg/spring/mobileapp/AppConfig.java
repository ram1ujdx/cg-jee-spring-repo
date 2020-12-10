package com.cg.spring.mobileapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cg.spring.mobileapp")
@PropertySource("beans.properties")
public class AppConfig {

}
