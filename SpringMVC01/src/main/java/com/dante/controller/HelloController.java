package com.dante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, name = "hello")
    public String printHello(ModelMap map) {
        map.addAttribute("message", "This message is From Controller!");
        return "hello";
    }
}
