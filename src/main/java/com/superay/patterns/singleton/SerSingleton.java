package com.superay.patterns.singleton;

import java.io.Serializable;

public class SerSingleton implements Serializable {
    private SerSingleton(){
        System.out.println("SerSingleton  is create");
    }

    private static SerSingleton instance = new SerSingleton();

    public static SerSingleton getInstance(){
        return instance;
    }

    /**
     * 对于实现 Serializable 或 Externalizable 接口的类来说，writeReplace() 方法可以使对象被写入流以前，用一个对象来替换自己。当序列化时，可序列化的类要将对象写入流，如果我们想要另一个对象来替换当前对象来写入流，则可以要实现下面这个方法，方法的签名也要完全一致：ANY-ACCESS-MODIFIER Object writeReplace() throws ObjectStreamException;
     * writeReplace()方法在 ObjectOutputStream 准备将对象写入流以前调用， ObjectOutputStream 会首先检查序列化的类是否定义了 writeReplace()方法，如果定义了这个方法，则会通过调用它，用另一个对象替换它写入流中。方法返回的对象要么与它替换的对象类型相同，要么与其兼容，否则，会抛出 ClassCastException 。
     *
     * 同理，当反序列化时，要将一个对象从流中读出来，我们如果想将读出来的对象用另一个对象实例替换，则要实现跟下面的方法的签名完全一致的方法。ANY-ACCESS-MODIFIER Object readResolve() throws ObjectStreamException;
     *
     * readResolve 方法在对象从流中读取出来的时候调用， ObjectInputStream 会检查反序列化的对象是否已经定义了这个方法，如果定义了，则读出来的对象返回一个替代对象。同 writeReplace()方法，返回的对象也必须是与它替换的对象兼容，否则抛出 ClassCastException。如果序列化的类中有这些方法，那么它们的执行顺序是这样的：
     * a. writeReplace()
     * b. writeObject()
     * c. readObject()
     * d. readResolve()
     * @return
     */
    //加入私有的readResolve后，readObject()会被取代，直接使用readResolve的返回值
    private Object readResolve(){
        System.out.println("readResolve doing");
        return instance;
    }

    private Object writeReplace(){
        System.out.println("writeReplace doing");
        return instance;
    }
}
