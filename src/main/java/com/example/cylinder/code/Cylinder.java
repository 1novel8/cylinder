package com.example.cylinder.code;



public class Cylinder {
    private double height;
    private double radius;
    private final double volume=3.14*radius*radius*height;
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


