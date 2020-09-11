package com.zhanghc.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

/**
 * 发布通道监听，对发布的信息做一定处理，模拟算法端对图片进行处理后发送到另一个通道
 */
public class SendListener implements MessageListener {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    @Qualifier(value = "receiveChannel")
    private ChannelTopic receiveTopic;


    @Override
    public void onMessage(Message message, byte[] bytes) {
        String body = new String(message.getBody());
        String channel = new String(message.getChannel());
        String pattern_ = new String(bytes);

        System.out.println(body);
        System.out.println(channel);
        System.out.println(pattern_);       // 如果是 ChannelTopic, 则 channel 字段与 pattern 字段值相同
        redisTemplate.convertAndSend(
                receiveTopic.getTopic(),
                body
        );
    }
}
