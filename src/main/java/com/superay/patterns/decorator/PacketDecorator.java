package com.superay.patterns.decorator;

/**
 * @Author Superay
 * @Description 维护核心组件component对象
 * @Date 23:27 2021/8/31
 * @Param 
 * @return 
 **/
public abstract class PacketDecorator implements IPacketCreator {
    IPacketCreator component;
    public PacketDecorator(IPacketCreator pc){
        component = pc;
        System.out.println("packetDecorator is created");
    }
}
