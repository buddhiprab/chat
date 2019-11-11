package com.buddhi.chat.service;

public interface MessagePublisher {
    void publish(String channel, String message);
}
