package com.superay.patterns.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        IPacketCreator pc = new PacketHttpHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(pc.handleContent());
    }
}
