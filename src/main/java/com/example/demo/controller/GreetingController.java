package com.example.demo.controller;
import com.example.demo.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/server")
    @SendTo("/chat/client")
    public Message greeting(Message message){

        return new Message( HtmlUtils.htmlEscape(message.getSender()), HtmlUtils.htmlEscape(message.getContent()));
    }
}
