package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.remote.HelloRemote;

@RestController
public class ConsumerController {

    @Autowired
    HelloRemote HelloRemote;
    
    @Value("${test.name}")
    private String testName;
	
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(String.format("%s---%s", name, testName));
    }

}