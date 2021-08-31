package com.superay;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.superay.patterns.singleton.Singleton;
import com.superay.patterns.singleton.StaticSingleton;
import com.superay.stream.FileUtils;
import com.superay.thread.RunnableDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
//        Singleton.createString();
//        System.out.printf(StaticSingleton.number);

//        StaticSingleton.getInstance();

        for(int i = 0; i<20;i++){
            RunnableDemo demo = new RunnableDemo("Thread-"+i);
            demo.start();
        }
    }
}
