package com.luke.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * Dubbo SPI机制测试:
 * 特点：按需获取
 * Dubbo 对配置文件目录的约定，不同于Java SPI，Dubbo 分为了三类目录：
 * META-INF/services/ 目录：该目录下的SPI配置文件是为了用来兼容Java SPI 。
 * META-INF/dubbo/ 目录：该目录存放用户自定义的 SPI 配置文件。
 * META-INF/dubbo/internal/ 目录：该目录存放Dubbo内部使用的SPI配置文件。
 * 注意：Dubbo SPI的接口需要使用@SPI注解声明，否则不识别
 * TODO Adaptive注解 - 自适应扩展/WrapperClass - AOP/injectExtension - IOC/Activate 注解
 */
public class MainDubbo {
    public static void main(String[] args) {
        ExtensionLoader<Person> loader=ExtensionLoader.getExtensionLoader(Person.class);
        Person teacher=loader.getExtension("teacher");
        teacher.printJob();
        Person cooker=loader.getExtension("cooker");
        cooker.printJob();
    }
}
