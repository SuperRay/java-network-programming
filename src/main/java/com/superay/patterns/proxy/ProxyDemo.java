package com.superay.patterns.proxy;

import static com.superay.patterns.proxy.ProxyUtil.*;

public class ProxyDemo {
    public  static  final int CIRCLE = 3000000;
    public static void main(String[] args) throws Exception {
        IDBQuery d = null;
        long begin = System.currentTimeMillis();
        d = createJdkProxy();
        System.out.println("createJdkProxy:" + (System.currentTimeMillis() - begin));
        System.out.println("JdkProxy class:" + d.getClass().getName());
        begin= System.currentTimeMillis();

        for(int i = 0; i<CIRCLE;i++){
            d.request();
        }
        System.out.println("callJdkProxy:" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        d = createCglibProxy();
        System.out.println("createCglibProxy:" + (System.currentTimeMillis() - begin));
        System.out.println("CglibProxy class:" + d.getClass().getName());
        begin= System.currentTimeMillis();

        for(int i = 0; i<CIRCLE;i++){
            d.request();
        }
        System.out.println("callCglibProxy:" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        d = createJavassistDynProxy();
        System.out.println("createJavassistDynProxy:" + (System.currentTimeMillis() - begin));
        System.out.println("JavassistDynProxy class:" + d.getClass().getName());
        begin= System.currentTimeMillis();

        for(int i = 0; i<CIRCLE;i++){
            d.request();
        }
        System.out.println("callJavassistDynProxy:" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        d = createJavassistBytecodeDynamicProxy();
        System.out.println("createJavassistBytecodeDynamicProxy:" + (System.currentTimeMillis() - begin));
        System.out.println("JavassistBytecodeDynamicProxy class:" + d.getClass().getName());
        begin= System.currentTimeMillis();

        for(int i = 0; i<CIRCLE;i++){
            d.request();
        }
        System.out.println("callJavassistBytecodeDynamicProxy:" + (System.currentTimeMillis() - begin));
    }
}
