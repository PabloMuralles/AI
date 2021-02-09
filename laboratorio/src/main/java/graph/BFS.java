/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author pablo
 */
public class BFS {
    
        public static<T>  Optional<Node<T>> search(T value, Node<T> start){
        
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);
        
        Node<T> currentNode;
        
        Set<Node<T>> closed = new HashSet<>();
        
        while(!queue.isEmpty()){//1- verifico si se puede continuar
            
            currentNode = queue.remove();
            System.out.println("Visistando el nodo" + currentNode.getValue());
            
            // 2- verifico si se encuentra en la metra
            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);
            }else{
                closed.add(currentNode);//3- espacio explorado
                queue.addAll(currentNode.getNeighbors());//-4 funcion sucesora
                queue.removeAll(closed);
            }
         
        }
        
        return Optional.empty();
    }
}
