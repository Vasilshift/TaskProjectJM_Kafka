package com.example.TaskProjectJM.Controllers;

import com.example.TaskProjectJM.Message;
import com.example.TaskProjectJM.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final ProducerService producerService;

    @Autowired
    public HomeController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/generate")
    public String generate(@RequestParam String message, @RequestParam Integer age) {
        producerService.produce(new Message(message, age));
        return "OK";
    }
}
