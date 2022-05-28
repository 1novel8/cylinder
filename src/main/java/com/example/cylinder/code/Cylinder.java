package com.example.cylinder.code;


import com.example.cylinder.CylinderApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
public class Cylinder {
    private double height;
    private double radius;

    public Cylinder(){}
    @Autowired
    public Cylinder(double r, double h){this.height=h;this.radius=r;}
    public void setHeight(double height) {this.height = height;}
    public void setRadius(double radius) {this.radius = radius;}
    public double getHeight() {return height;}
    public double getRadius() {return radius;}
    public double getVolume(){return 3.14*radius*radius*height;}
}


