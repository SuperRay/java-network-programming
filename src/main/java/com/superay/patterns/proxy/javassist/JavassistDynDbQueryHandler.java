package com.superay.patterns.proxy.javassist;

import com.superay.patterns.proxy.DBQuery;
import com.superay.patterns.proxy.IDBQuery;
import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

public class JavassistDynDbQueryHandler implements MethodHandler {
    IDBQuery real = null;
    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if(real == null){
            real = new DBQuery();
        }
        return real.request();
    }
}
