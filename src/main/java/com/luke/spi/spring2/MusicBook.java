package com.luke.spi.spring2;

public class MusicBook implements Book {
    @Override
    public void printBookName() {
        System.out.println("书：音乐书！！！");
    }
}
