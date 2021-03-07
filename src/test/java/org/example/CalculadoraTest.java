package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void probarSuma(){
        //Resultado Esperado
        double esperado = 25;

        // Ejecutar y obtener
        var calculador = new Calculadora();
        var obtenido = calculador.sumar(5,20);

        //Comparar esperado vs obtenido
        assertEquals(esperado,obtenido);
    }
}
