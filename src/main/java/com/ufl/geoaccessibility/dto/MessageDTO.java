package com.ufl.geoaccessibility.dto;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple DTO class to encapsulate messages along with their timestamps.
 */
public class MessageDTO {

    public Date date;
    public String content;

    public MessageDTO(String message) {
        this.date = Calendar.getInstance().getTime();
        this.content = message;
    }
}
