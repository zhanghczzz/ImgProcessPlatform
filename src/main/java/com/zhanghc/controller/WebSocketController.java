package com.zhanghc.controller;

import com.zhanghc.util.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 使用web接口进行测试
@RestController
public class WebSocketController {

    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/sendAllWebSocket")
    public String sendAllWebSockets(){
        webSocket.sendAllMessage("清晨起来打开窗，心情美美哒~");
        return "websocket群体发送";
    }

    @RequestMapping("/sendOneWebSocket")
    public String sendOneWebSocket(){
        webSocket.sendOneMessage("zhanghc", "你要年薪百万");
        return "websocket单人发送";
    }

}
