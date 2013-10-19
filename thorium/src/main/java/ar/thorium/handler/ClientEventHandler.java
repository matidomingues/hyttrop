package ar.thorium.handler;

import ar.thorium.utils.ChannelFacade;

import java.nio.ByteBuffer;

public interface ClientEventHandler extends EventHandler {
    ByteBuffer nextMessage(ChannelFacade channelFacade);
    void handleInput(ByteBuffer message, ChannelFacade channelFacade);
    void handleConnection(ChannelFacade facade);
}
