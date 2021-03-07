package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculadoraTest {

    Calculadora calculadora;

    @BeforeAll
    public static void startup(){
        System.out.println("Inicializacion global ----------");
    }

    @BeforeEach
    public void init(){
        calculadora = new Calculadora();
        System.out.println("Inicializando test ---------");
    }
    @Test
    public void probarSuma(){
        assertEquals(25.0,calculadora.sumar(5,20));
        System.out.println("Sumando . . . ");
    }
    
    @Test
    public void probarResta(){
        assertEquals(30.0,calculadora.restar(50,20));
        System.out.println("Restando . . . ");
    }

    @Test
    public void probarMultiplicacion(){
        assertEquals(25.0,calculadora.multiplicar(5,5));
        System.out.println("Multiplicando . . . ");
    }

    @AfterEach
    public void shutdown(){
        System.out.println("Finalizando test ----------");
    }

    @AfterAll
    public static void destroy(){
        System.out.println("Finalizacion global ----------");
    }
}
