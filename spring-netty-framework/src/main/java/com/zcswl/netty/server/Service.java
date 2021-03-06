package com.zcswl.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**、
 * netty-example 源码包
 * @author zhoucg
 * @date 2020-03-04 16:07
 */
public class Service {

    /**
     * 服务端口
     */
    private int port = 9999;

    public void startNetty() {

        /**
         * 创建两个EventLoopGroup EventLoop 这个相当于一个处理线程，
         * 是Netty接收请求和处理IO请求的线程。不理解的话可以百度NIO图解
         *
         *
         * 相关资料：NioEventLoopGroup是一个处理I/O操作的多线程事件循环。
         * Netty为不同类型的传输提供了各种EventLoopGroup实现。
         *
         * 在本例中，我们正在实现一个服务器端应用程序，因此将使用两个NioEventLoopGroup。
         * 第一个，通常称为“boss”，接受传入的连接。
         * 第二个，通常称为“worker”，当boss接受连接并注册被接受的连接到worker时，处理被接受连接的流量。
         * 使用了多少线程以及如何将它们映射到创建的通道取决于EventLoopGroup实现，甚至可以通过构造函数进行配置。
         *
         */
        EventLoopGroup acceptor = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();

        try {

            // 1，创建启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 2，配置启动参数等
            /**设置循环线程组，前者用于处理客户端连接事件，后者用于处理网络IO(server使用两个参数这个)
             *public ServerBootstrap group(EventLoopGroup group)
             *public ServerBootstrap group(EventLoopGroup parentGroup, EventLoopGroup childGroup)
             */
            bootstrap.group(acceptor, worker);

            /**设置选项
             * 参数：Socket的标准参数（key，value），可自行百度
             * eg:
             * bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
             * :bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
             */
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);

            // 用于构造socketChannel工厂
            bootstrap.channel(NioServerSocketChannel.class);

            // 传入自定义的客户端handler
            bootstrap.childHandler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    /**
                     * 传递对象操作
                     */
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE,  ClassResolvers.cacheDisabled(null)));
                    //ch.pipeline().addLast(new SimpleServerHandler());
                    ch.pipeline().addLast(new SimpleServerObjectHandler());
                }
            });

            // 绑定端口，开始接口进来的连接
            ChannelFuture future = bootstrap.bind(port).sync();

            // 等待服务器 socket 关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            acceptor.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }


    public static void main(String[] args) {
        // 启动服务端
        new Service().startNetty();

    }
}
