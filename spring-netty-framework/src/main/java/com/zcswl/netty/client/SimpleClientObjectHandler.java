package com.zcswl.netty.client;

import com.zcswl.netty.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author zhoucg
 * @date 2020-11-19 15:17
 */
public class SimpleClientObjectHandler extends SimpleChannelInboundHandler<Message>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        // 客户端去读
        System.out.println("客户端收到了对应读取的信息");
        System.out.println("Client:" + msg);
        ctx.write(build());
        ctx.flush();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.write(build());
        ctx.flush();
    }

    public Message build() {
        Message message = new Message();
        message.setCode("Client:" + new Random().nextInt(10000));
        message.setId("CLIENT");
        message.setMessage("客户端数据，code不同");

        return message;
    }
}
