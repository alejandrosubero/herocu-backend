package com.backenwebmail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin(origins = "*")
//@RequestMapping("/")
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "/index.html";
    }
}
