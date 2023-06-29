package com.luke.spi.spring2;

public class EnglishBook implements Book {
    @Override
    public void printBookName() {
        System.out.println("书：English 英语书！！！");
    }
}
