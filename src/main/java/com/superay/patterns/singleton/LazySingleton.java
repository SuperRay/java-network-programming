package com.superay.patterns.singleton;

/**
 * 延迟加载单例模式
 */
public class LazySingleton {
    private  LazySingleton(){
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    //使用同步锁保证单例在多线程下不会重复创建
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
