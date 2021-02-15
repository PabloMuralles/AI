package org.example.functional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {

    //Generador de datos

    public static List<Integer> createRandomList(int qty){
        var random = new Random();
        List<Integer> numbers = new LinkedList<>();

        for (int i = 0; i<qty; i++){
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    //programacion imperativa
    public static List<Integer> sortList(List<Integer> unsortedList){
        Collections.sort(unsortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2.compareTo(t1);
            }
        });
        return  unsortedList;
    }

    //programacion declarativa
    public static List<Integer> sortLamdaList(List<Integer> unsortedList){
        Collections.sort(unsortedList, (t1, t2) -> t2.compareTo(t1));

        return  unsortedList;
    }

    public static boolean isPrimeNumber (int n){
        if (n <= 1){
            return false;
        }

        var counter = 0;

        for (int i = n-1; i > 1; i--){
            if (n%i==0){
                counter ++;
            }
        }
        return  counter <= 0;
    }

    public static  void main( String args[]){

        /*System.out.println("Calculando aleatorio");

        var listadoPrimos = createRandomList(Integer.valueOf(args[0])).parallelStream()
                .filter(n -> isPrimeNumber(n))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Finalizando Calculo");
        System.out.println("Primer primo "+listadoPrimos.get(0));
        //System.out.println(listadoPrimos);*/

        /*var primos = IntStream.range(0,100).boxed()
                .filter(n -> isPrimeNumber(n))
                .collect(Collectors.toList());

        System.out.println(primos);

        var randomNumber = createRandomList(10);
        System.out.println(randomNumber);
        sortLamdaList(randomNumber);
        System.out.println(randomNumber);*/


    }
}
