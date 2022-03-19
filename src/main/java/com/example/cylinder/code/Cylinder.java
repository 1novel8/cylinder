package com.example.cylinder.code;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Cylinder {
    @Min(value = 0, message = "height should be  more than 0")
    private double height;
    @Min(value = 0, message = "Radius should be  more than 0")
    private double radius;
    private double volume=3.14*radius*radius*height;;
    public Cylinder(){}
    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }
    public void setHeight(double height) {this.height = height;}
    public void setRadius(double radius) {this.radius = radius;}
    public double getHeight() {return height;}
    public double getRadius() {return radius;}
    public double getVolume(){return 3.14*radius*radius*height;}
}


