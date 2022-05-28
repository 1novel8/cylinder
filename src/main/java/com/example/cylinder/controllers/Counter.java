package com.example.cylinder.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Counter {
    private static int counter;

    @GetMapping("/calls")
    public synchronized int getCalls(){
        return this.counter;
    }
    public synchronized void increase(){
        this.counter++;
    }
    public Counter(){
        this.counter=0;
    }
}
