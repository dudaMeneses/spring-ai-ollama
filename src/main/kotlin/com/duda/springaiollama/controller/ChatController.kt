package com.duda.springaiollama.controller

import com.duda.springaiollama.records.Payload
import com.duda.springaiollama.service.OllamaChatGenerator
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/chat")
class ChatController(val chatGenerator: OllamaChatGenerator) {

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun chat(@RequestBody payload: Payload): Map<*, *> {
        return this.chatGenerator.generate(payload.strings)
    }
}