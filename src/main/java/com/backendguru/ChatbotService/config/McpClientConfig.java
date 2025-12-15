package com.backendguru.ChatbotService.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpClientConfig {

    @Bean
    ChatClient chatClient(OpenAiChatModel model, ToolCallbackProvider mcpToolProvider) {
        return ChatClient.builder(model)
// Bağlı MCP server'lardaki TÜM tool'ları LLM'e varsayılan olarak ver
                .defaultToolCallbacks(mcpToolProvider)
                .build();
    }
}
