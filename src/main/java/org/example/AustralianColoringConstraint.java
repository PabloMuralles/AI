package org.example;

import java.util.List;
import java.util.Map;

public class AustralianColoringConstraint extends Constraint<String,String>{

    private String place1,place2;

    public AustralianColoringConstraint(String place1,String place2){
        super(List.of(place1,place2));
        this.place1 = place1;
        this.place2 = place1;
    }


    @Override
    public boolean satisfied(Map<String, String> assigment) {
        // se debe chaquear que
        //la variable no se encuentre aun asignada
        if (!assigment.containsKey(place1) || !assigment.containsKey(place2)){
            return true;
        }
        //lugar 1 <> lugar 2 -> distinto
        return !assigment.get(place1).equals(place2);
    }
}
