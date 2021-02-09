/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author pablo
 */
public class DFS {
    
    public static<T>  Optional<Node<T>> search(T value, Node<T> start){
        
        Stack<Node<T>> stack = new Stack<>();
        stack.push(start);
        
        Set<Node<T>> closed = new HashSet<>();
        
        var same = false;
        
        Stack<String> routes = new Stack<>();
        Stack<Node<T>> successors = new Stack<>();
        Stack<String> temp = new Stack<>();
        routes.push(start.toString());
        
        while(!stack.isEmpty()){//1- verifico si se puede continuar
            
            var currentNode = stack.pop();
            System.out.println("Visitando: "+currentNode.getValue());
            var father = routes.pop();
            
            // 2- verifico si se encuentra en la metra
            if(currentNode.getValue().equals(value)){
                System.out.println(father);
                return Optional.of(currentNode);
            }else{
                closed.add(currentNode);//3- espacio explorado
                stack.addAll(currentNode.getNeighbors());//-4 funcion sucesora
                successors.addAll(currentNode.getNeighbors());
                stack.removeAll(closed);
                for(Node<T> node: successors){
                    routes.add(father+"->"+node.getValue());
                }
                successors=new Stack<>();
                same = false;
                for(String route: routes){
                    var splitRoute = route.split("->");
                    var lenghtRoute = Integer.valueOf(splitRoute[splitRoute.length-1]);
                    for(Node<T> close: closed){
                        var data = close.getValue();
                        if (data.equals((lenghtRoute))) {
                            same = true;
                        }   
                    }
                    if (!same) {
                        temp.add(route);
                    }else{
                        same = false;
                    }
                }
                routes=temp;
                temp=new Stack<>();
            }
        }
        
        System.out.println("No se encontro");
        return Optional.empty();
    }
}
