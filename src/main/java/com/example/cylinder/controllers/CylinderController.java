package com.example.cylinder.controllers;
import com.example.cylinder.code.Cylinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CylinderController {
    @GetMapping("/")
    public String homeView(@ModelAttribute("cylinder") @Valid Cylinder cylinder, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "index";
        return "index";
    }
//    @GetMapping("/get")
//    public String countedView(@ModelAttribute("cylinder") Cylinder cylinder){
//        return "index";
//    }
}

