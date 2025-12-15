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

    /** 1
     * iade işlemlerini başlat.
     * @param chatbotRequestDto
     * @return
     */
    @PostMapping("/orderReturnProcess")
    public String orderReturnProcess(@RequestBody ChatbotRequestDto chatbotRequestDto){
        String s = chatService.orderReturnProcess(chatbotRequestDto.prompt());

        System.out.println("test");
        return s;
    }

    /** 2
     * return true case
     * @param chatbotRequestDto
     * @return
     */
    @PostMapping("/v2/orderReturnProcess")
    public ReturnOrderProcessResponseDto orderReturnProcessReturnTrue(@RequestBody ChatbotRequestDto chatbotRequestDto){
        return chatService.orderReturnProcessReturnTrue(chatbotRequestDto.prompt());

    }

    /** 3
     * orderReturnProcessReturnTrueWithoutConverter
     * return
     * @param chatbotRequestDto
     * @return
     */
    @PostMapping("/v3/orderReturnProcess")
    public ReturnOrderProcessResponseDto orderReturnProcessReturnTrueWithoutConverter(@RequestBody ChatbotRequestDto chatbotRequestDto){
        return chatService.orderReturnProcessReturnTrueWithoutConverter(chatbotRequestDto.prompt());

    }

    /**
     * 4
     * @param chatbotRequestDto
     * @return
     */
    @PostMapping("/v4/orderReturnProcess")
    public String orderReturnProcessReturnWrongPrompt(@RequestBody ChatbotRequestDto chatbotRequestDto){
        return chatService.orderReturnProcessReturnWrongPrompt(chatbotRequestDto.prompt());

    }

    /** 5
     * iade işlemlerini başlat. Mail gönder
     * @param chatbotRequestDto
     * @return
     */
    @PostMapping("/orderReturnProcessSendMail")
    public String orderReturnProcessSendMail(@RequestBody ChatbotRequestDto chatbotRequestDto){
        String s = chatService.orderReturnProcessSendMail(chatbotRequestDto.prompt());

        System.out.println("test");
        return s;
    }



}
