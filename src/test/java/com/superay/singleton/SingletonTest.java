package com.superay.singleton;

import com.superay.patterns.singleton.SerSingleton;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class SingletonTest {

    @Test
    public void testSerSingleton() throws Exception {
        SerSingleton s1 = null;
        SerSingleton s = SerSingleton.getInstance();

        FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("SerSingleton.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (SerSingleton) ois.readObject();

        Assert.assertEquals(s, s1);

    }
}
