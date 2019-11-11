package com.buddhi.chat.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChatMessage implements Serializable {
    String message;
}
