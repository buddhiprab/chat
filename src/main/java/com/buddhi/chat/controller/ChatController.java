package com.buddhi.chat.controller;

import com.buddhi.chat.dto.ChatMessage;
import com.buddhi.chat.service.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @PostMapping(path="/")
    public ResponseEntity sendChat(@RequestBody ChatMessage chatMessage) {
//        redisTemplate.opsForList().leftPush("A_B", "A to B");
//        Long val = redisTemplate.opsForList().size("A_B");
//        String val1 = redisTemplate.opsForList().index("A_B", 0);
//        String message = "Message " + UUID.randomUUID();
        redisMessagePublisher.publish("A_B", chatMessage.getMessage());
        return new ResponseEntity(HttpStatus.OK);
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
}
