package com.example.cylinder.code;


import com.example.cylinder.CylinderApplication;
import org.springframework.stereotype.Component;
@Component
public class Cylinder {
    private double height;
    private double radius;

    public Cylinder(){}

    public void setHeight(double height) {this.height = height;}
    public void setRadius(double radius) {this.radius = radius;}
    public double getHeight() {return height;}
    public double getRadius() {return radius;}
    public double getVolume(){return 3.14*radius*radius*height;}
}


