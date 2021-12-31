package com.example.demo.controller;
import com.example.demo.dto.Connection;
import com.example.demo.dto.Message;
import com.example.demo.dto.SystemMessage;
import com.example.demo.enumeration.SystemMessageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessagingController {
    private Logger log = LogManager.getLogger(MessagingController.class);

    @MessageMapping("/server/{id}")
    @SendTo("/chat/client/{id}")
    public Message sendMessage(@DestinationVariable String id, Message message){
        log.debug("Received message {} from {}",message.getContent(),message.getSender());
        return new Message( HtmlUtils.htmlEscape(message.getSender()), HtmlUtils.htmlEscape(message.getContent()));
    }

    @MessageMapping("/server/{id}/connect")
    @SendTo("/chat/client/updates/{id}")
    public SystemMessage connect(@DestinationVariable String id, Connection connection){
        log.debug("Received connection: {}", connection.toString());
        return new SystemMessage(SystemMessageType.USER_JOINED,HtmlUtils.htmlEscape(connection.getUsername()));
    }
}
