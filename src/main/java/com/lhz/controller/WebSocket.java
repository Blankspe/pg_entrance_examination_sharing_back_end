package com.lhz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        log.info("Connection opened for user: {}", username);
        // 在此处可以添加用户上线逻辑
    }

    @OnClose
    public void onClose(Session session) {
        log.info("Connection closed");
        // 在此处可以添加用户下线逻辑
    }

    @OnMessage
    public String onMessage(String message) {
        log.info("Received message: {}", message);
        // 处理接收到的消息并返回响应
        return "Server received your message: " + message;
    }

    @OnError
    public void onError(Throwable throwable) {
        log.error("Error occurred in WebSocket communication", throwable);
    }
}
