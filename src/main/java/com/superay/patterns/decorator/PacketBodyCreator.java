package com.superay.patterns.decorator;

public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent() {
        return "Content of packet"; //构造核心数据，但不包含格式
    }
}
