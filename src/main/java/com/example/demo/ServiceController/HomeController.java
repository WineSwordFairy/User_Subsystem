package com.example.demo.ServiceController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/Home")
    public String Index(){
        return "AccountSystem!";

    }
}
