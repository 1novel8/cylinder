package com.example.cylinder.controllers;
import com.example.cylinder.code.Cache;
import com.example.cylinder.code.Cylinder;
import com.example.cylinder.exceptions.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CylinderController {
    private final Cylinder cylinder=new Cylinder();
    private final Cache cache=new Cache();

    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("volume", "0");
        return "index";
    }

    @GetMapping("/get")
    public String countedView(@RequestParam(name="height") double height,
                              @RequestParam(name="radius") double radius,
                              Model model) throws ServiceException {
        cylinder.setHeight(height);
        cylinder.setRadius(radius);

        if(radius<0 || height<0) {
            throw new ServiceException("height and radius should be more than 0");
        }
        model.addAttribute("height", cylinder.getHeight());
        model.addAttribute("radius", cylinder.getRadius());

        model.addAttribute("volume",cache.getValue(cylinder));
        return "index";
    }
}

