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

/**
 *
 * @author pablo
 */
public class GraphSearchBFS {
    
        public static<T>  Optional<Node<T>> searchV2(T value, Node<T> start){
        
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);
        
        Node<T> currentNode=queue.remove();
        
        Set<Node<T>> closed = new HashSet<>();
        
        closed.add(currentNode); 
        queue.addAll(currentNode.getNeighbors()); 
        
        var father = currentNode.toString();
        var flag = false;
        
        List<String> routes = new ArrayList<>();
        List<Node<T>> successors = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        
        for(Node<T> node : queue){
            routes.add(father+"->"+node.getValue());
        }
        
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
        routes = temp;
        temp = new ArrayList<>();
        
        while(!queue.isEmpty()){//1- verifico si se puede continuar
            
            currentNode = queue.remove();
            father = routes.remove(0);
            
            // 2- verifico si se encuentra en la metra
            if(currentNode.getValue().equals(value)){
                System.out.println(father);
                return Optional.of(currentNode);
            }else{
                if (!closed.contains(currentNode)) {
                    closed.add(currentNode);//3- espacio explorado
                    queue.addAll(currentNode.getNeighbors());//-4 funcion sucesora
                }
                 
                successors.addAll(currentNode.getNeighbors());
                //queue.removeAll(closed);
                for(Node<T> node: successors){
                    routes.add(father+"->"+node.getValue());
                }
                successors=new ArrayList<>();
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
                temp=new ArrayList<>();
            }
        }
        
        return Optional.empty();
    }
}
