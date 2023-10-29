package com.mybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AboutController {

    @ModelAttribute("module")
    String module() {
        return "about";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "value");
        return "about";
    }
}
