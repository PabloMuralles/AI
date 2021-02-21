package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSP <V, D>{

    private List<V> variables;
    private Map<V, List<D>> domains;
    private Map<V,List<Constraint<V, D>>> constraints = new HashMap<>();

    public CSP(List<V> variables, Map<V, List<D>> domins){
        this.variables = variables;
        this.domains = domins;

        for (V variable: variables) {
            constraints.put(variable, new ArrayList<Constraint<V,D>>());
            //verficar que cada variable debe de tener un dominio asignado
            //cada variable debe de tener su dominio compatible que debe de ser discreto y finito
            // y segundo los constrains que afectan a las variables
            if (!domains.containsKey(variable)) {
                throw new IllegalArgumentException("La variable "+ variable+" no contiene un dominio");
            }
        }

    }

    public  void addConstraint(Constraint<V, D> constraint){
        for (V variable: constraint.variables) {
            //verficar que la variable que se encuentra en el constraint tambien sea parte del CSP

            if (!this.variables.contains(variable)){
                throw new IllegalArgumentException("La variable "+variable+" no se encuentra en el CSP");
            }
            constraints.get(variable).add(constraint);
        }
    }

    public boolean consistent(V variable, Map<V,D> assignment){
        for (Constraint<V, D> constraint:this.constraints.get(variable)) {
            if (!constraint.satisfied(assignment)){
                return false;
            }
        }
        return true;
    }

    public Map<V, D> backtrack(){
        return backtrack(new HashMap<>());
    }

    public Map<V,D> backtrack(Map<V, D> assigment){
        // si la asginacion es completa(si cada variable tiene un valor)-condicion de salida
        if (variables.size() == assigment.size()){
            return assigment;
        }
        //seleccionar una variable no asginada
        V unssigned = variables.stream()
                .filter(v -> !assigment.containsKey(v))
                .findFirst().get();

        for (D value:domains.get(unssigned)){
            System.out.println("Variable: " + unssigned+ "valor: "+value);

            //probar una asignacion
            //1- crear una copia de la asginacion anterior
            Map<V, D> localAssigment = new HashMap<>(assigment);
            //2- probar (aka asginar un valor)
            localAssigment.put(unssigned,value);
            //3- verficar la consistencia de la asignacion

            if (consistent(unssigned,localAssigment)){
                Map<V, D> result = backtrack(localAssigment);

                if (result != null){
                    return  result;
                }
            }
        }
        return null;
    }











}
