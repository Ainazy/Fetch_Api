package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

        @GetMapping("/admin")
        public String MainPage(){ return "index"; }


        @GetMapping("/users")
        public String users(){ return "user"; }

        @GetMapping("/new")
        public String create(){ return "New"; }
}
