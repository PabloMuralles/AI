package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexConstraint {

    List<String> variables;

    Map<String, List<String>> domains = new HashMap<>();

    public ComplexConstraint(){
        variables= List.of("A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J",
                "K",
                "L",
                "M",
                "N",
                "O",
                "P",
                "Q",
                "R",
                "S",
                "T",
                "U",
                "V",
                "W",
                "X",
                "Y",
                "Z","AA");

        for (var variable:variables ){
            domains.put(variable, List.of("c","m","y","k"));
        }

        CSP<String,String> problem = new CSP<>(variables,domains);
        problem.addConstraint(new AustralianColoringConstraint("A", "B"));
        problem.addConstraint(new AustralianColoringConstraint("A", "V"));
        problem.addConstraint(new AustralianColoringConstraint("B", "V"));
        problem.addConstraint(new AustralianColoringConstraint("C", "D"));
        problem.addConstraint(new AustralianColoringConstraint("C", "F"));
        problem.addConstraint(new AustralianColoringConstraint("C", "H"));
        problem.addConstraint(new AustralianColoringConstraint("D", "G"));
        problem.addConstraint(new AustralianColoringConstraint("D","H"));
        problem.addConstraint(new AustralianColoringConstraint("E", "I"));
        problem.addConstraint(new AustralianColoringConstraint("F", "K"));
        problem.addConstraint(new AustralianColoringConstraint("G", "K"));
        problem.addConstraint(new AustralianColoringConstraint("H", "V"));
        problem.addConstraint(new AustralianColoringConstraint("H", "M"));
        problem.addConstraint(new AustralianColoringConstraint("I", "M"));
        problem.addConstraint(new AustralianColoringConstraint("J", "K"));
        problem.addConstraint(new AustralianColoringConstraint("J", "N"));
        problem.addConstraint(new AustralianColoringConstraint("K", "O"));
        problem.addConstraint(new AustralianColoringConstraint("L", "P"));
        problem.addConstraint(new AustralianColoringConstraint("L", "Q"));
        problem.addConstraint(new AustralianColoringConstraint("M", "Q"));
        problem.addConstraint(new AustralianColoringConstraint("P","S"));
        problem.addConstraint(new AustralianColoringConstraint("P", "T"));
        problem.addConstraint(new AustralianColoringConstraint("P", "U"));
        problem.addConstraint(new AustralianColoringConstraint("R", "S"));
        problem.addConstraint(new AustralianColoringConstraint("R", "W"));
        problem.addConstraint(new AustralianColoringConstraint("R", "X"));
        problem.addConstraint(new AustralianColoringConstraint("S", "X"));
        problem.addConstraint(new AustralianColoringConstraint("S", "Y"));
        problem.addConstraint(new AustralianColoringConstraint("S", "Z"));
        problem.addConstraint(new AustralianColoringConstraint("T", "U"));
        problem.addConstraint(new AustralianColoringConstraint("T", "Z"));
        problem.addConstraint(new AustralianColoringConstraint("T", "AA"));
        problem.addConstraint(new AustralianColoringConstraint("U", "AA"));
        problem.addConstraint(new AustralianColoringConstraint("V", "W"));
        problem.addConstraint(new AustralianColoringConstraint("W", "X"));
        problem.addConstraint(new AustralianColoringConstraint("X", "Y"));
        problem.addConstraint(new AustralianColoringConstraint("Y", "Z"));
        problem.addConstraint(new AustralianColoringConstraint("Z", "AA"));

        var solution = problem.backtrack();

        System.out.println(solution);

    }

}
