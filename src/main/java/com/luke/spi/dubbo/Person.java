package com.luke.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

/**
 * Dubbo的SPI机制要求接口必须使用@SPI注解声明
 */
@SPI
public interface Person {
    void printJob();
}
