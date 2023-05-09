package com.cocoa.netty.file;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.DefaultFileRegion;
import io.netty.util.CharsetUtil;
import org.jetbrains.annotations.NotNull;

import java.io.RandomAccessFile;

public class FileServerHandler extends ChannelInboundHandlerAdapter {

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) {
//        ctx.writeAndFlush("HELLO: Type the path of the file to retrieve.\n");
//    }


    @Override
    public void channelRead(@NotNull ChannelHandlerContext ctx, @NotNull Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            ByteBuf in = (ByteBuf) msg;
            String filePath= in.toString(CharsetUtil.UTF_8);
            System.out.println("EchoServerHandler server received+ " + in.toString(CharsetUtil.UTF_8));
//            ctx.write(in);
//            ctx.write(in);
//            super.channelRead(ctx, msg);

            System.out.println("channelRead0=>" );
            RandomAccessFile raf = null;
            long length = -1;
            try {
                raf = new RandomAccessFile(filePath, "r");
                length = raf.length();
            } catch (Exception e) {
                ctx.writeAndFlush("ERR: " + e.getClass().getSimpleName() + ": " + e.getMessage() + '\n');
                return;
            } finally {
                if (length < 0 && raf != null) {
                    raf.close();
                }
            }
            System.out.println("raf.length() =>" + raf.length());
            ctx.write("OK: " + raf.length() + '\n');
            // SSL not enabled - can use zero-copy file transfer.
            ctx.write(new DefaultFileRegion(raf.getChannel(), 0, length));
            ctx.writeAndFlush("\n");



        }
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }


//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        System.out.println("channelRead0=>" );
//        RandomAccessFile raf = null;
//        long length = -1;
//        try {
//            raf = new RandomAccessFile(msg, "r");
//            length = raf.length();
//        } catch (Exception e) {
//            ctx.writeAndFlush("ERR: " + e.getClass().getSimpleName() + ": " + e.getMessage() + '\n');
//            return;
//        } finally {
//            if (length < 0 && raf != null) {
//                raf.close();
//            }
//        }
//        ctx.write("OK: " + raf.length() + '\n');
//        // SSL not enabled - can use zero-copy file transfer.
//        ctx.write(new DefaultFileRegion(raf.getChannel(), 0, length));
//        ctx.writeAndFlush("\n");
//        System.out.println("raf.length() =>" + raf.length());
//
//
//    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        if (ctx.channel().isActive()) {
            ctx.writeAndFlush("ERR: " +
                    cause.getClass().getSimpleName() + ": " +
                    cause.getMessage() + '\n').addListener(ChannelFutureListener.CLOSE);
        }
    }


}
