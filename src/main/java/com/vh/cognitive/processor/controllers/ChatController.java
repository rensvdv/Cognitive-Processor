package com.vh.cognitive.processor.controllers;

import com.vh.cognitive.processor.model.Request;
import com.vh.cognitive.processor.model.Response;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/ask")
    public Response ask(@RequestBody Request request) {
        long start = System.currentTimeMillis();

        String answer = this.chatClient.prompt()
                .user(request.getMessage())
                .call()
                .content();

        long end = System.currentTimeMillis();
        long latency = end - start; 

        Response response = new Response(answer, latency, end);
        return response;
    }

}
