package com.yoshikiohashi.biztoi.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @RequestMapping("/sample")
    fun index(): String {
        return "hello World !!"
    }
}