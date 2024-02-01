package com.example.springbootintro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // Dette svarer til @RestController metode
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> sayHello2() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

}
