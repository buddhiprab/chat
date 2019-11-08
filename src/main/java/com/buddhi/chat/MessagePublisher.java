package com.buddhi.chat;

public interface MessagePublisher {
    void publish(String channel, String message);
}
