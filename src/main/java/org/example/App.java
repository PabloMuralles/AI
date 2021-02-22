package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //CSP
        //Variables
        List<String> variables = List.of("Western Australia", "Nothern Territory",
                "Queensland","South Australia", "New South Wales","Victoria","Tasmania");
        //Dominios
        Map<String, List<String>> domains = new HashMap<>();
        for (var variable:variables ){
            domains.put(variable, List.of("rojo","verde","azul"));
        }
        //Restricciones
        CSP<String,String> problema = new CSP<>(variables,domains);
        problema.addConstraint(new AustralianColoringConstraint("Western Australia","Nothern Territory"));
        problema.addConstraint(new AustralianColoringConstraint("Western Australia","South Australia"));
        problema.addConstraint(new AustralianColoringConstraint("Nothern Territory","South Australia"));
        problema.addConstraint(new AustralianColoringConstraint("Nothern Territory","Queensland"));
        problema.addConstraint(new AustralianColoringConstraint("South Australia","Queensland"));
        problema.addConstraint(new AustralianColoringConstraint("New South Wales","Queensland"));
        problema.addConstraint(new AustralianColoringConstraint("New South Wales","South Australia"));
        problema.addConstraint(new AustralianColoringConstraint("Victoria","South Australia"));
        problema.addConstraint(new AustralianColoringConstraint("New South Wales","Victoria"));
        problema.addConstraint(new AustralianColoringConstraint("Tasmania","Victoria"));

        var solution = problema.backtrack();


        //System.out.println(solution);

        var objComplex = new ComplexConstraint();


    }
}
