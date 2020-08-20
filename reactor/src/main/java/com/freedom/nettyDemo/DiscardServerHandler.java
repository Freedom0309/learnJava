package com.freedom.nettyDemo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Copyright: Copyright (c) 2020 TD
 *
 * <p> Description:
 *
 * @author liufeng
 * @version 2020/7/15 16:16
 * @since v1.0.0
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
//            ctx.write(msg);
//            ctx.flush();
        ctx.writeAndFlush(msg);
        // Discard the received data silently.
       /* ByteBuf in = (ByteBuf) msg;
        try {
            // do something
            System.out.println((char) in.readByte());
            System.out.flush();
        } finally {

            ((ByteBuf) msg).release();
        }*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
