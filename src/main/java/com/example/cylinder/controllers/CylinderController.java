package com.example.cylinder.controllers;
import com.example.cylinder.code.Cylinder;
import com.example.cylinder.exceptions.ServiceException;
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
    public String countedView(@RequestParam() double height,
                              @RequestParam() double radius,
                              Model model) throws ServiceException {
        Cylinder cylinder =new Cylinder(height, radius);
        model.addAttribute("height", cylinder.getHeight());
        model.addAttribute("radius", cylinder.getRadius());
        if(radius<0 || height<0) {
            throw new ServiceException("height and radius should be more than 0");
        }
        model.addAttribute("volume",cylinder.getVolume());
        return "index";
    }
}

