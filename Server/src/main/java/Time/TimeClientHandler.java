package Time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        ByteBuf m = (ByteBuf) msg; // (1)
        try {
            long currentTimeMillis = m.readLong() * 1000L;
            System.out.println(new Date(currentTimeMillis) + "    msg = " + msg);
            ctx.close();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
            cause.printStackTrace();
            ctx.close();
        }

}
