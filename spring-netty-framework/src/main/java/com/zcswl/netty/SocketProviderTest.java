package com.zcswl.netty;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * 
 * jdk nio编码
 * @author zhoucg
 * @date 2020-11-20 15:09
 */
public class SocketProviderTest {

    public static void main(String[] args) throws IOException {


        SelectorProvider selectorProvider = SelectorProvider.provider();
        SocketChannel socketChannel = selectorProvider.openSocketChannel();

        Socket socket = socketChannel.socket();

    }

}
