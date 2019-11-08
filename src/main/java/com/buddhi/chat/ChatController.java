package com.buddhi.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ChatController {
    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @GetMapping(path="/")
    public String test(@RequestBody String message) {
//        redisTemplate.opsForList().leftPush("A_B", "A to B");
//        Long val = redisTemplate.opsForList().size("A_B");
//        String val1 = redisTemplate.opsForList().index("A_B", 0);
//        String message = "Message " + UUID.randomUUID();
        redisMessagePublisher.publish("A_B", message);
        return message;
    }
}
