package com.zhanghc.controller;

import com.alibaba.fastjson.JSON;
import com.zhanghc.vo.CityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    @Qualifier(value = "sendChannel")
    private ChannelTopic sendTopic;


    @GetMapping("/publish")
    public String publish(){
        redisTemplate.convertAndSend(
                sendTopic.getTopic(),
                JSON.toJSONString(new CityInfo("hefei", 117.17, 31.52))
        );
        return "success";
    }
}
