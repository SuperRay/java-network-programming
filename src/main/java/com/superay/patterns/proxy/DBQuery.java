package com.superay.patterns.proxy;

public class DBQuery implements IDBQuery {

    public DBQuery(){
        System.out.println("DBQuery is created");
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }

    @Override
    public String request() {

        return "request string";
    }
}
