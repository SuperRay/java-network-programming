package com.superay.patterns.decorator;

public class PacketHttpHeaderCreator extends PacketDecorator {
    public PacketHttpHeaderCreator(IPacketCreator pc) {
        super(pc);
    }

    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Tue,31Aug202123:39:40GMT\n");
        sb.append(component.handleContent());
        return sb.toString();
    }
}
