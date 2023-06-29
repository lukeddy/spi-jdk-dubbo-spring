package com.luke.spi.spring;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * Spring SPI机制示例：
 * Spring SPI沿用了Java SPI的设计思想，Spring采用的是META-INF/spring.factories方式实现SPI机制，可以在不修改Spring源码的前提下，提供Spring框架的扩展性。
 */
public class MainSpring {
    public static void main(String[] args) {
        List<Tree> treeList = SpringFactoriesLoader.loadFactories(Tree.class, Thread.currentThread().getContextClassLoader());
        for(Tree tree:treeList){
            tree.printName();
        }
    }
}
