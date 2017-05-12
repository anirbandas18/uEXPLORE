package com.ufl.geoaccessibility.reciever;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ufl.geoaccessibility.dto.MessageDTO;

@Controller
public class GuestbookController {

    /**
     * Listens the /app/guestbook endpoint and when a message is received, encapsulates it in a MessageDTO instance and relays the resulting object to
     * the clients listening at the /topic/entries endpoint.
     * 
     * @param message the message
     * @return the encapsulated message
     */
    @MessageMapping("/guestbook")
    @SendTo("/topic/entries")
    public MessageDTO guestbook(String message) {
        System.out.println("Received message: " + message);
        return new MessageDTO(message);
    }
}