package com.mycompany.laboratorio;

import graph.BFS;
import graph.DFS;
import graph.Node;
import graph.BFSVersion2;
 

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
        var zona9 = new Node<Integer>(9);
        var zona10 = new Node<Integer>(10);
        var zona12 = new Node<Integer>(12);
        var zona13 = new Node<Integer>(13);
        var zona14 = new Node<Integer>(14);
        var zona15 = new Node<Integer>(15);
        var zona16 = new Node<Integer>(16);
        var zona21 = new Node<Integer>(21);
        
        
       zona1.connect(zona2);
       zona1.connect(zona4);
       zona1.connect(zona5);
       zona1.connect(zona9);
       zona4.connect(zona5);
       zona4.connect(zona9);
       zona4.connect(zona10);
       zona9.connect(zona10);
       zona9.connect(zona13);
       zona10.connect(zona14);
       zona10.connect(zona15);
       zona12.connect(zona13);
       zona12.connect(zona21);
       zona13.connect(zona14);
       zona15.connect(zona16);
        
        System.out.println("BFS\n");
        BFS.search(16,zona21);
        System.out.println("\n");
        System.out.println("BFS Version 2\n");
        BFSVersion2.search(16, zona21);
        System.out.println("\n");
        System.out.println("DFS\n");
        DFS.search(16, zona21);
    }
}
