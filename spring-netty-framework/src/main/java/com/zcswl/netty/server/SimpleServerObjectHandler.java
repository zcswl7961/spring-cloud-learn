package com.zcswl.netty.server;

import com.zcswl.netty.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author zhoucg
 * @date 2020-11-19 15:09
 */
public class SimpleServerObjectHandler extends SimpleChannelInboundHandler<Message> {




    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {

        // 服务断去读
        System.out.println("服务断收到了对应读取的信息");
        System.out.println("Server:" + msg);
        ctx.write(build());
        ctx.flush();

    }


    public Message build() {
        Message message = new Message();
        message.setCode("Server:" + new Random().nextInt(10000));
        message.setId("SERVER");
        message.setMessage("服务断数据，code不同");

        return message;
    }

}
