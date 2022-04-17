package com.nagarro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/spring")
public class SpringController {

    @GetMapping(value = "/persons", produces = MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello From Spring !";
    }
}
