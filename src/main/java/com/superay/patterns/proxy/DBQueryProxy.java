package com.superay.patterns.proxy;

public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    @Override
    public String request() {
        if(real == null){
            //真正需要时才创建真实的对象，因为创建过程可能很缓慢
            real = new DBQuery();
        }
        return real.request();
    }
}
