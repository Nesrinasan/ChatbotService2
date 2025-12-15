package com.backendguru.ChatbotService.controller;

import com.backendguru.ChatbotService.alarm.DateTimeTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toolCalling")
public class ToolCallingController {

    private final OpenAiChatModel chatModel;

    public ToolCallingController( OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/noToolCalling/currentTime")
    public String noToolCallingCurrentTime(){

        return ChatClient.create(chatModel)
                .prompt("What day is tomorrow?")
                .call()
                .content();

    }


    @GetMapping("/getDate")
    public String currentTime(){
        return ChatClient.create(chatModel)
                .prompt("What day is tomorrow?")
                .tools(new DateTimeTools())
                .call()
                .content();

    }



    @GetMapping("/setAlarm")
    public String toolCallingCurrentTime(){

        return ChatClient.create(chatModel)
                .prompt("Can you set an alarm 10 minutes from now?")
                .tools(new DateTimeTools())
                .call()
                .content();


    }

}
