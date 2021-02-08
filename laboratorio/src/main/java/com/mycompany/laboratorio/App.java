package com.mycompany.laboratorio;

import graph.BFS;
import graph.Node;
 

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        var zona1 = new Node<Integer>(1);
        var zona2 = new Node<Integer>(2);
        var zona5 = new Node<Integer>(5);
        var zona4 = new Node<Integer>(4);
        var zona10 = new Node<Integer>(10);
        var zona15 = new Node<Integer>(15);
        var zona16 = new Node<Integer>(16);
        
        zona1.connect(zona2);
        zona1.connect(zona5);
        zona1.connect(zona4);
        zona5.connect(zona4);
        zona4.connect(zona10);
        zona10.connect(zona15);
        zona15.connect(zona16);
        
        BFS.search(16,zona2);
        
    }
}
