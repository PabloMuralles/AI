package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class URLArrayListTest {

/*    URLArrayList arrayList;

    @BeforeEach
    public void init(){
        arrayList = new URLArrayList();
    }*/

    @Test
    @DisplayName("Prueba Lista")
    public void testList(){
        List list = new URLArrayList();

        list.add(0,10);

        assertEquals(10,list.get(0));

    }




}
