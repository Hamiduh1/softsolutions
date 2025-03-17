package com.softsolutions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/it")
    public String itServices() {
        return "it";
    }

    @GetMapping("/cybersecurity")
    public String cybersecurity() {
        return "cybersecurity";
    }

    @GetMapping("/software")
    public String softwareDevelopment() {
        return "software";
    }

    @GetMapping("/ai")
    public String aiServices() {
        return "ai";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}
