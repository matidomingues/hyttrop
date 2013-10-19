package ar.thorium.dispatcher;

import ar.thorium.handler.EventHandler;
import ar.thorium.handler.HandlerAdapter;
import ar.thorium.utils.ChannelFacade;

import java.io.IOException;
import java.nio.channels.SelectableChannel;

public interface Dispatcher {

	void dispatch() throws IOException;

	void shutdown();

	ChannelFacade registerChannel(SelectableChannel channel,
                      EventHandler handler) throws IOException;

	void unregisterChannel(ChannelFacade key);

	void enqueueStatusChange(HandlerAdapter adapter, Object handle);

	Thread start();
}
