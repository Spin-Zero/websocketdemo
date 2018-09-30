package com.jinxing.chatroom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@org.springframework.stereotype.Controller
public class Controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String message) {
        log.info("收到消息: " + message);
        if (principal.getName().equals("Bob")) {
            log.info("收到Bob的消息");
            messagingTemplate.convertAndSendToUser(
                     "Alice",
                    "/queue/notifications",
                    principal.getName() + "-send: " + message);
        } else {
            log.info("收到Alice的消息");
            messagingTemplate.convertAndSendToUser(
                    "Bob",
                    "/queue/notifications",
                    principal.getName() + "-send: " + message);
        }
    }

}
