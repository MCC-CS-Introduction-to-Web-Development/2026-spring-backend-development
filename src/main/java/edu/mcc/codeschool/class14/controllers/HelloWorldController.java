package edu.mcc.codeschool.class14.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloWorldController {

    Logger logger = Logger.getLogger(HelloWorldController.class.getName());

    @GetMapping
    public String getHello(){
        logger.info("Get Hello world");
        return "Get Hello world";
    }

    @PostMapping
    public String postHello(){
        logger.info("Post Hello world");
        return "Post Hello world";
    }

    @GetMapping("/{name}")
    public String sayHelloPerson(@PathVariable String name){
        logger.info("Hello there, " + name);
        return "Hello there, " + name;
    }
}
