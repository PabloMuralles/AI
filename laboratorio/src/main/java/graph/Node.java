/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pablo
 */
public class Node<T> {
    private T value;
    private Set<Node<T>> neighbors;
    private boolean visited;
    
    public Node(T value){
        this.value = value;
        this.neighbors = new HashSet<>();
    }
    
    public T getValue(){
        return this.value;
    }
    
    public Set<Node<T>> getNeighbors(){
        return Collections.unmodifiableSet(neighbors);
    }
    
    public void connect(Node<T> node){
        if (this == node){
            throw new IllegalArgumentException("Un nodo intenta referenciarse a si mismo");
        }
        this.neighbors.add(node);
        node.neighbors.add(this);
    }
    
    public String toString(){
        return this.value.toString();
    }
    
    public boolean getVisited(){
        return this.visited;
    }
    
    public void setVisited(boolean visited){
        this.visited = visited;
    }
}
