package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class CSP <V, D>{

    private List<V> variables;
    private Map<V, List<D>> domains;
    private Map<V,List<Constraint<V, D>>> constraints = new HashMap<>();

    public CSP(List<V> variables, Map<V, List<D>> domains){
        this.variables = variables;
        this.domains = domains;

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

    //parametros:
    //valor V que se acaba de ingresar -> para poder validar los arcos
    // dominio D que se acaba de escoger para valor -> para saber como validar los arcos
    //dominio actual copia -> para poder modificarlos sin dañar el original y poder ahcer backtrack
    public Map<V, List<D>>  AC3(V value,D valueDomain ,Map<V, List<D>> copyDomains){

        var tempDomains = copyDomains;
        var tempConstraints = constraints.get(value);
        List<V> neightbord = new ArrayList<>();

        for (var tempNightbord: tempConstraints) {
            /*if (tempNightbord.variables.get(0) != value){
                neightbord.add(tempNightbord.variables.get(0));
            }else{
                neightbord.add(tempNightbord.variables.get(1));
            }*/
            neightbord.add(tempNightbord.variables.stream().filter(x -> !x.equals(value)).findFirst().get());
        }

        var newDomainValue = tempDomains.get(value).stream()
                .filter(x->x.equals(valueDomain))
                .collect(Collectors.toList());
        tempDomains.replace(value,newDomainValue);

        for (var tempNightbord : neightbord) {
            var newDomain = tempDomains.get(tempNightbord).stream()
                    .filter(x->!x.equals(valueDomain))
                    .collect(Collectors.toList());
            tempDomains.replace(tempNightbord,newDomain);
        }

        return tempDomains;

    }

    public Map<V, D> backtrack(){
        return backtrack(new HashMap<>(),domains);
    }

    public Map<V,D> backtrack(Map<V, D> assigment,Map<V, List<D>> domains){
        // si la asginacion es completa(si cada variable tiene un valor)-condicion de salida
        if (variables.size() == assigment.size()){
            return assigment;
        }
        //seleccionar una variable no asginada
        V unssigned = variables.stream()
                .filter(v -> !assigment.containsKey(v))
                .findFirst().get();

        for (D value:domains.get(unssigned)){
            System.out.println("Variable: " + unssigned+ " valor: "+value);

            //probar una asignacion
            //1- crear una copia de la asginacion anterior
            Map<V, D> localAssigment = new HashMap<>(assigment);
            Map<V,List<D>> localDomains = new HashMap<>(domains);
            //2- probar (aka asginar un valor)
            localAssigment.put(unssigned,value);
            //3- verficar la consistencia de la asignacion

            if (consistent(unssigned,localAssigment)){

                var newDomins = AC3(unssigned,value,localDomains);
                Map<V, D> result = backtrack(localAssigment,newDomins);

                if (result != null || newDomins != null){
                    return  result;
                }
            }
        }
        return null;
    }











}
