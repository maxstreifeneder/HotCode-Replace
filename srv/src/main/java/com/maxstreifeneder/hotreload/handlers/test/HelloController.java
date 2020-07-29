package com.maxstreifeneder.hotreload.handlers.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/redirect")
    public String greeting() {
        System.out.println("REDIRECT");
        return "test";
    }
}