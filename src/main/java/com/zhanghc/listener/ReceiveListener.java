package com.zhanghc.listener;

import com.zhanghc.util.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class ReceiveListener implements MessageListener {

    @Autowired
    private WebSocket webSocket;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String body = new String(message.getBody());
        String channel = new String(message.getChannel());
        String pattern_ = new String(bytes);

        System.out.println(body);
        System.out.println(channel);
        System.out.println(pattern_);       // 如果是 ChannelTopic, 则 channel 字段与 pattern 字段值相同

        webSocket.sendOneMessage("zhanghc", body);
    }
}
