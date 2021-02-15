package org.example;

import org.example.functional.MyFunctionalInterface;
import org.example.functional.Pickachu;
import org.example.functional.Tux;

import java.util.List;

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

    public static void doSomethingFunctional() {
        //funcion anonima
        // esto es un comportamiento
        MyFunctionalInterface clippy = (String param) -> {
            return "Hola soy clippy y recibi " + param;
        };
        // esto es un comportamiento
        MyFunctionalInterface wilbert = (p) -> "Hola soy Wilbert y recibi " + p;

        /*doSomethingHighOrder(clippy);
        doSomethingHighOrder(wilbert);
        doSomethingHighOrder(x -> "Hola soy anonymus y recibi" + x);*/

        /*Tux tux = new Tux();
        //referenciar a codigo existente en otra clase siempre y cuando la funcion cumpla con la firma de la interfas funcinal ::
        doSomethingHighOrder(tux::doSomething);*/

        Pickachu pickachu = new Pickachu();
        doSomethingHighOrder(pickachu::pika);
        doSomethingHighOrder(pickachu::impactrueno);

    }

    //funcion high order que recibe un comportamieto
    public static void doSomethingHighOrder(MyFunctionalInterface comportamiento){
        // Ejecuto el comportamiento que recibi como comportamiento

        String respuesta = comportamiento.doSomething("Java 11 es genial");
        System.out.println(respuesta);
    }
    public static void main( String[] args )
    {
        //doSomethingFunctional();

        List jedis = List.of("Yoda","Windu","Anakin", "Luke","Rey");

        //poo
        /*for (int i=0; i<jedis.size(); i++){
            Object jedi = jedis.get(i);
            System.out.println(jedi);
        }*/

        //jedis.forEach(param -> System.out.println(param));

        //funcion high order que es forEach esto ya es programacion funcional
        jedis.forEach(System.out::println);


    }
}
