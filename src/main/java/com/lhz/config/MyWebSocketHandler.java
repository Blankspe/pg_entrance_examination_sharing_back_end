package com.lhz.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhz.config.dto.InstanceMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Component
@Slf4j
public class MyWebSocketHandler extends TextWebSocketHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static Map<Integer,WebSocketSession> sessionsMap = new ConcurrentHashMap<Integer, WebSocketSession>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session);
        String senderId = session.getUri().toString().split("senderId=")[1];
        sessionsMap.put(Integer.valueOf(senderId),session);
        System.out.println("Connection established");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            InstanceMsgDTO msgDTO = objectMapper.readValue(message.getPayload(), InstanceMsgDTO.class);
            Integer senderId = msgDTO.getSenderId();
            Integer receiverId = msgDTO.getReceiverId();
            String msg = msgDTO.getMsg();
            log.info("Received：{},发送者：{}，接收者：{} " , msgDTO.getMsg(),senderId,receiverId);
            WebSocketSession receiverSession = sessionsMap.get(receiverId);
            receiverSession.sendMessage(new TextMessage(JSON.toJSONString(msgDTO)));
        }catch (Exception ex){
            log.info("异常信息：{}",ex);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionsMap.remove(session);
        System.out.println("Connection closed");
    }
}