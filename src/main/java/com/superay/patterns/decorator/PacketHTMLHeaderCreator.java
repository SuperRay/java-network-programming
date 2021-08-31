package com.superay.patterns.decorator;

public class PacketHTMLHeaderCreator extends PacketDecorator {
    public PacketHTMLHeaderCreator(IPacketCreator pc) {
        super(pc);
    }
    @Override
    public String handleContent(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(component.handleContent());
        sb.append("</body>");
        sb.append("</html>\n");
        return sb.toString();
    }
}
