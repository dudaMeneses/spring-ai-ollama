package com.duda.springaiollama.controller

import com.duda.springaiollama.records.Payload
import com.duda.springaiollama.records.Response
import com.duda.springaiollama.service.OllamaEmbeddingGenerator
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/embeddings")
class EmbeddingController(val generator: OllamaEmbeddingGenerator) {

    @PostMapping(value = ["/1"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchEmbeddings1(@RequestBody payload: Payload): Response {
        return Response(this.generator.getEmbeddingsWithModelOverride(payload).getResult())
    }

    @PostMapping(value = ["/1"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchEmbeddings2(@RequestBody payload: Payload?): Map<String, EmbeddingResponse> {
        return this.generator.getEmbeddingsWithDefaultModel(payload)
    }
}