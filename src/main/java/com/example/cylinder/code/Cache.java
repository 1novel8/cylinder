package com.example.cylinder.code;
import com.example.cylinder.CylinderApplication;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class Cache {

    private final Map map;
    public Cache(){
        map=new HashMap<Pair<Double, Double>, Double>();
    }
    @Autowired
    public Double getValue(Cylinder cylinder){

        Pair<Double, Double> pair = new ImmutablePair<>(cylinder.getHeight(), cylinder.getRadius());
        if(!map.containsKey(pair)){
            map.put(pair, cylinder.getVolume());
        }
        return (Double) map.get(pair);
    }
}
