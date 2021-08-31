package com.superay.thread;

import com.superay.patterns.singleton.LazySingleton;
import com.superay.patterns.singleton.Singleton;
import com.superay.patterns.singleton.StaticSingleton;

public class RunnableDemo implements Runnable {

    private String threadName;
    private Thread t;
    private long begintime;

    public RunnableDemo(String name){
        begintime= System.currentTimeMillis();
        threadName = name;
        System.out.println("Creating " + name);
    }

    public void run() {
        System.out.println("Running " +  threadName );
        for(int i = 0; i <100000;i++){
            StaticSingleton.getInstance();}
            System.out.println("spend:"+ (System.currentTimeMillis() - begintime));

        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}
