/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author pablo
 */
public class DFS {
    
    public static<T>  Optional<Node<T>> search(T value, Node<T> start){
        
        Stack<Node<T>> queue = new Stack<>();
        queue.add(start);
        
        Node<T> currentNode=queue.pop();
        
        Set<Node<T>> closed = new HashSet<>();
        
        closed.add(currentNode); 
        queue.addAll(currentNode.getNeighbors()); 
        
        var father = currentNode.toString();
        var flag = false;
        
        Stack<String> routes = new Stack<>();
        Stack<Node<T>> successors = new Stack<>();
        Stack<String> temp = new Stack<>();
        
 
        routes.push(father+"->"+currentNode.getValue());
     
        
        while(!queue.isEmpty()){//1- verifico si se puede continuar
            
            currentNode = queue.pop();
            father = routes.pop();
            
            // 2- verifico si se encuentra en la metra
            if(currentNode.getValue().equals(value)){
                System.out.println(father);
                return Optional.of(currentNode);
            }else{
                closed.add(currentNode);//3- espacio explorado
                queue.addAll(currentNode.getNeighbors());//-4 funcion sucesora
                successors.addAll(currentNode.getNeighbors());
                queue.removeAll(closed);
                for(Node<T> node: successors){
                    routes.add(father+"->"+node.getValue());
                }
                successors=new Stack<>();
                flag = false;
                for(String route: routes){
                    var splitRoute = route.split("->");
                    var lenghtRoute = Integer.valueOf(splitRoute[splitRoute.length-1]);
                    for(Node<T> close: closed){
                        var data = close.getValue();
                        if (data.equals((lenghtRoute))) {
                            flag = true;
                        }   
                    }
                    if (!flag) {
                        temp.add(route);
                    }else{
                        flag = false;
                    }
                }
                routes=temp;
                temp=new Stack<>();
            }
        }
        
        return Optional.empty();
    }
}
