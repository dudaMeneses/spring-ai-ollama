package com.duda.springaiollama.service

import com.duda.springaiollama.records.Payload
import org.springframework.stereotype.Service


@Service
class OllamaEmbeddingGenerator(val embeddingClient: EmbeddingClient) {
    fun getEmbeddingsWithModelOverride(payload: Payload): EmbeddingResponse {
        return embeddingClient.call(EmbeddingRequest(
            listOf(payload.strings()),
            OllamaOptions.create().withModel("mistral")))
    }

    fun getEmbeddingsWithDefaultModel(payload: Payload): Map<String, EmbeddingResponse> {
        return mapOf("embedding" to embeddingClient.embedForResponse(listOf(payload.strings())))
    }
}