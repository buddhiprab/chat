package com.buddhi.chat.service;

import com.buddhi.chat.dto.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WebSocketMessageService {
    private final SimpMessagingTemplate template;

    public WebSocketMessageService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Async
    public void sendChatMessage(ChatMessage message) {
        template.convertAndSend("A_B", message);
    }
}
