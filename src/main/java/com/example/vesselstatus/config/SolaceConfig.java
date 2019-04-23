package com.example.vesselstatus.config;


import com.solace.camel.component.jms.SolaceJmsFactoryProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {SolaceJmsFactoryProperties.class})
public class SolaceConfig {
}
