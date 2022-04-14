package com.example.cylinder.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void setHeight() {

    }

    @Test
    void setRadius() {
    }

    @Test
    void getHeight() {
        Cylinder cylinder= new Cylinder();
        cylinder.setHeight(1.);
        assertEquals(1., cylinder.getHeight());
    }

    @Test
    void getRadius() {
        Cylinder cylinder= new Cylinder();
        cylinder.setRadius(2.);
        assertEquals(2., cylinder.getRadius());
    }

    @Test
    void getVolume() {
        Cylinder cylinder= new Cylinder();
        cylinder.setHeight(1.);
        cylinder.setRadius(2.);
        assertEquals(12.56, cylinder.getVolume());
    }
}