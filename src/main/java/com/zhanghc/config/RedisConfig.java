package com.zhanghc.config;

import com.zhanghc.listener.ReceiveListener;
import com.zhanghc.listener.SendListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisConfig {
    private final RedisConnectionFactory redisConnectionFactory;

    // 自动依赖注入
    @Autowired
    public RedisConfig(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    // 配置发布的消息监听器
    @Bean
    public SendListener sendListener(){
        return new SendListener();
    }

    // 配置接收的消息监听器
    @Bean
    public ReceiveListener receiveListener(){
        return new ReceiveListener();
    }

    // 配置发布的topic
    @Bean(value = "sendChannel")
    public ChannelTopic sendChannelTopic(){
        return new ChannelTopic("send");
    }

    // 配置接收的topic
    @Bean(value = "receiveChannel")
    public ChannelTopic receiveChannelTopic(){
        return new ChannelTopic("receive");
    }

    // 配置ChannelName的模式匹配
    @Bean
    public PatternTopic patternTopic(){
        return new PatternTopic("/city/*");
    }

    // 将消息监听器绑定到消息容器
    @Bean
    public RedisMessageListenerContainer messageListenerContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        // 可以修改成 patternTopic, 看一看 MessageListener 中监听的数据
        container.addMessageListener(sendListener(), sendChannelTopic());
        container.addMessageListener(receiveListener(), receiveChannelTopic());
        return container;
    }
}
