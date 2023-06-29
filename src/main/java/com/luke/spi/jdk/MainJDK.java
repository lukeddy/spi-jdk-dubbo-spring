package com.luke.spi.jdk;

import com.sun.tools.javac.util.ServiceLoader;

import java.util.Iterator;

/**
 * JDK SPI机制测试:通过在 META-INF/services/目录下创建以接口全限定名命名的文件实现
 * 特点：一次性获取所有资源
 * 案例：JDBC驱动，如：Mysql,Oracle
 */
public class MainJDK {
    public static void main(String[] args) {
        ServiceLoader<Animal> loader=ServiceLoader.load(Animal.class);
        Iterator<Animal> iterator = loader.iterator();
        while (iterator.hasNext()){
            Animal animal = iterator.next();
            animal.printAnimalName();
        }
    }
}
