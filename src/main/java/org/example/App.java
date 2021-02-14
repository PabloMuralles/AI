package org.example;

import org.example.functional.MyFunctionalInterface;
import org.example.functional.Tux;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void  doSomethingTraditional(){
        Tux tux = new Tux();
        System.out.println(tux.doSomething("Holi"));
    }

    public static void doSomethingClassy(){
        MyFunctionalInterface duke = new MyFunctionalInterface() {
            @Override
            public String doSomething(String param) {
                return  "Hola soy duke y recibi "+ param;
            }
        };
        System.out.println(duke.doSomething("Clase anonima"));
    }
    public static void main( String[] args )
    {
        doSomethingTraditional();
        doSomethingClassy();
    }
}
