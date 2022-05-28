package com.example.cylinder.controllers;
import com.example.cylinder.code.Cache;
import com.example.cylinder.code.Cylinder;
import com.example.cylinder.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class CylinderController {
    private Cache cache;
    @Autowired
    public void setCache(Cache cache){this.cache=cache;}
    private final Counter counter=new Counter();

    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("volume", "0");
        return "index";
    }

    @GetMapping("/get")
    public String countedView(@RequestParam(name="height") double height,
                              @RequestParam(name="radius") double radius,
                              Model model) throws ServiceException {
        Cylinder cylinder=new Cylinder();
        counter.increase();
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

    @PostMapping("/bulk")
    public ResponseEntity<?> doBulk(@RequestBody List<Cylinder> params) {

        List<Double> volume = new ArrayList<>();

        for (Cylinder smth:params) {
            volume.add(smth.getVolume());
        }
        Map<String, Object> map = new HashMap<>();

        map.put("avergeV", volume
                .stream()
                .mapToDouble(d -> d)
                .average()
                .orElseThrow(NoSuchElementException::new));
        map.put("maxV", volume
                .stream()
                .mapToDouble(d -> d)
                .max()
                .orElseThrow(NoSuchElementException::new));
        map.put("minV", volume
                .stream()
                .mapToDouble(d -> d)
                .min()
                .orElseThrow(NoSuchElementException::new));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}


