package com.luke.spi.spring2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeanRegistrar.class)
public class AppConfig {
}
