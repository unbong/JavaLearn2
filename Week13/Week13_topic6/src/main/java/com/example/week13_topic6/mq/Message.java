package com.example.week13_topic6.mq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class Message<T> {

    private HashMap<String, Object> header;
    private T body;
}
