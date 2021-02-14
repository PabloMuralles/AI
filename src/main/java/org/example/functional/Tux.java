package org.example.functional;

public class Tux implements MyFunctionalInterface {

    @Override
    public String doSomething(String param) {
        return "Hola soy Tux y recibi el siguiente parametro " + param;
    }
}
