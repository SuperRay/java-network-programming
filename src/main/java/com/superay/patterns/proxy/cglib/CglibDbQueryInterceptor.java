package com.superay.patterns.proxy.cglib;

import com.superay.patterns.proxy.DBQuery;
import com.superay.patterns.proxy.IDBQuery;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDbQueryInterceptor implements MethodInterceptor {
    IDBQuery real = null;
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if(real == null){
            real = new DBQuery();
        }
        return real.request();
    }
}
