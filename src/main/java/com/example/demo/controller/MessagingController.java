package com.example.demo.controller;
import com.example.demo.dto.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessagingController {
    @MessageMapping("/server/{id}")
    @SendTo("/chat/client/{id}")
    public Message sendMessage(@DestinationVariable String id, Message message){

        return new Message( HtmlUtils.htmlEscape(message.getSender()), HtmlUtils.htmlEscape(message.getContent()));
    }
}
