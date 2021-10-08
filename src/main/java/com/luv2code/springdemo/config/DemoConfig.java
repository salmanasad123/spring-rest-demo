package com.luv2code.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


// this is our Spring configuration class for Spring container
// @ComponentScan to tell spring which packages to look to find restControllers, controllers, pojos etc
@Configuration
@EnableWebMvc
@ComponentScan("com.luv2code.springdemo")
public class DemoConfig {

}
