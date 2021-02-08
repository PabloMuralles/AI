package com.mycompany.laboratorio;

import graph.Node;
 

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Node<String> node1 = new Node<>("hola");
        
        Node<Integer> node2 = new Node<>(5);
        
        var node3 = new Node<Boolean>(true);
        
        System.out.println(node1);
        System.out.println(node2);
        
        
    }
}
