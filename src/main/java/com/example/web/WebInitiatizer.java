package com.example.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.TpSpringSopapMvcApplication;

public class WebInitiatizer extends SpringBootServletInitializer{
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
// TODO Auto-generated method stub
return builder.sources(TpSpringSopapMvcApplication.class);
}
}
