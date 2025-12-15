package com.backendguru.ChatbotService.controller;

import com.backendguru.ChatbotService.dto.ChatbotRequestDto;
import com.backendguru.ChatbotService.dto.ReturnOrderProcessResponseDto;
import com.backendguru.ChatbotService.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ChatbotController {

    private final ChatService chatService;
    public ChatbotController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/orderReturnProcess")
    public String orderReturnProcess(@RequestBody ChatbotRequestDto chatbotRequestDto){
        String s = chatService.orderReturnProcess(chatbotRequestDto.prompt());

        System.out.println("test");
        return s;
    }

    @PostMapping("/v2/orderReturnProcess")
    public ReturnOrderProcessResponseDto orderReturnProcessReturnTrue(@RequestBody ChatbotRequestDto chatbotRequestDto){
        return chatService.orderReturnProcessReturnTrue(chatbotRequestDto.prompt());

    }

}
