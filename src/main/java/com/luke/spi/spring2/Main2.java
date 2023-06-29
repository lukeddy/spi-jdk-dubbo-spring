package com.luke.spi.spring2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 基于Spring SPI将bean对象注册到IOC容器，并获取
 */
public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //从容器中获取Bean实例
        Book book = context.getBean(EnglishBook.class);
        book.printBookName();

        Book musicBook = context.getBean(MusicBook.class);
        musicBook.printBookName();

        context.close();
    }
}
