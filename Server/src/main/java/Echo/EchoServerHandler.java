package Echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Server received: " + msg);
        ctx.write("hello from server " + msg + "\r\n");
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
    }

//    public void channelReadComplete(ChannelHandlerContext ctx){
//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
//                .addListener(ctx.);
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
