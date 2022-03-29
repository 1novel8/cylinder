package com.example.cylinder.controllers;
import com.example.cylinder.code.Cylinder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CylinderController {
    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("volume", "0");
        return "index";
    }

    @GetMapping("/get")
    public String countedView(@RequestParam(required = true) double height, @RequestParam(required = true) double radius, Model model){
        Cylinder cylinder =new Cylinder(height, radius);
        model.addAttribute("height", cylinder.getHeight());
        model.addAttribute("radius", cylinder.getRadius());
        model.addAttribute("volume",cylinder.getVolume());
        return "index";
    }
}

