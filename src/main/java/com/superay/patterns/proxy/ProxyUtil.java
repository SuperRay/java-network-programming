package com.superay.patterns.proxy;

import com.superay.patterns.proxy.cglib.CglibDbQueryInterceptor;
import com.superay.patterns.proxy.javassist.JavassistDynDbQueryHandler;
import com.superay.patterns.proxy.jdk.JdkDbQueryHandler;
import javassist.*;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class ProxyUtil {
    /**
     * 创建jdk动态代理
     * @return
     */
    public static IDBQuery createJdkProxy(){
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{IDBQuery.class},
                new JdkDbQueryHandler()
        );
        return jdkProxy;
    }

    /**
     * 创建cglib动态代理
     * @return
     */
    public static IDBQuery createCglibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor());
        enhancer.setInterfaces(new Class[] {IDBQuery.class});
        IDBQuery cglibProxy = (IDBQuery) enhancer.create();

        return cglibProxy;
    }

    /**
     * 代理工厂创建javassist动态代理
     * @return
     * @throws Exception
     */
    public static IDBQuery createJavassistDynProxy() throws  Exception{
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class});
        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();

        //设置处理器
        ((ProxyObject)javassistProxy).setHandler(new JavassistDynDbQueryHandler());

        return javassistProxy;
    }

    /**
     * 动态字节码方式生成javassist动态代理
     * @return
     * @throws Exception
     */
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {
        ClassPool mPool = new ClassPool(true);
        //定义类名
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() +"JavassistBytecodeProxy");
        //实现需要的接口
        mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
        //添加需要的构造函数
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        //添加类的字段信息，使用动态java代码
        mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + " real;",mCtc));

        String dbqueryname = DBQuery.class.getName();
        //添加方法，这里使用动态Java代码指定内部逻辑
        mCtc.addMethod(CtNewMethod.make("public String request() { if(real == null) real= new " + dbqueryname +"();return real.request(); }",mCtc));

        //基于以上信息，生成动态类
        Class pc = mCtc.toClass();
        //生成动态类实例
        IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();

        return bytecodeProxy;
    }
}
