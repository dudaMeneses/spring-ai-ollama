package com.duda.springaiollama.service

import org.springframework.stereotype.Service

@Service
class OllamaChatGenerator(val chatClient: OllamaChatClient) {

    fun generate(message: String?): Map<*, *> {
        return mapOf("generation" to this.ollamaChatClient.call(message))
    }
}