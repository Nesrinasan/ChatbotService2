package com.backendguru.ChatbotService.service;



import com.backendguru.ChatbotService.dto.ReturnOrderProcessResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final ChatModel chatModel;


    public ChatService(ChatClient chatClient, ChatModel chatModel) {
        this.chatClient = chatClient;
        this.chatModel = chatModel;
    }

    public String orderReturnProcess(String prompt) {
        String system = """
                Görevin: mevcut MCP araçlarını kullanarak kullanıcının talebi olan siparişi iade etme sürecini başlatan akışı oluştur.  
                
                """;

        String user = "Kullanıcının iade etmek istediği sipariş detayı:" + prompt;

        String content = chatClient.prompt()
                .system(system)
                .user(user)
                .call()
                .content();
        System.out.println("sonuç alındı");
        return content;
    }


    public ReturnOrderProcessResponseDto orderReturnProcessReturnTrue(String promptStr) {

        BeanOutputConverter<ReturnOrderProcessResponseDto> beanOutputConverter = new BeanOutputConverter<>(new ParameterizedTypeReference<ReturnOrderProcessResponseDto>() { });

        String format = beanOutputConverter.getFormat();

        String system = """
                Görevin: mevcut MCP araçlarını kullanarak kullanıcının talebi olan siparişi iade etme sürecini başlatan akışı oluştur. ve kullanıcya
                 hepsiburada@gmail.com adresinden siparişin durumu ile ilgili 
                anlamlı bir mail gönder. 
                {format}
                """;

        String user = "Kullanıcı maili nesrin.asan@gmail.com. Kullanıcının iade etmek istediği sipariş detayı:" + promptStr;
        PromptTemplate promptTemplate = PromptTemplate.builder().template(system + user).build();
        Prompt promptV = promptTemplate.create(Map.of("format", format));

        // 3. LLM çağrısı
        Generation generation = chatModel.call(promptV).getResult();

        // 4. JSON çıktısını DTO'ya dönüştürme (Sizin ProductDto dönüşümünüze benzer)
        return beanOutputConverter.convert(generation.getOutput().getText());

    }
}