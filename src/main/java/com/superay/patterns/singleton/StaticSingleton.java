package com.superay.patterns.singleton;

/**
 * 静态内部类单例模式
 */
public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }

    //静态内部类只有在被使用的时候才会被初始化，不会随着StaticSingleton加载时进行初始化
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

    public static String number = "3";
}
