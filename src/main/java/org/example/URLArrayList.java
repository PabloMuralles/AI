package org.example;

import java.util.Arrays;
import java.util.Objects;

public class URLArrayList implements List {

    private Object[] elements;
    //private int size;

    @Override
    public int size() {return this.elements.length;}

    @Override
    public boolean isEmpty() {return this.elements.length==0;}

    @Override
    public Object get(int i) throws IndexOutOfBoundsException {
        //Objects.checkIndex(i,size);
        return elements[i];
    }

    @Override
    public Object set(int i, Object o) throws IndexOutOfBoundsException {
        //Objects.checkIndex(i,size);
        Object old = elements[i];
        elements[i]=o;
        return old;
    }

    @Override
    public void add(int i, Object o) throws IndexOutOfBoundsException {
         if (elements == null){
             elements = new Object[1];
             elements[0]=o;
         }else{
             elements = Arrays.copyOf(elements,elements.length+1);
             var temp = Arrays.copyOf(elements,elements.length+1);
             elements[i]=o;
             for (int j=0;j<i;j++){
                 elements[j]=temp[j];
             }
             for (int j=i+1;j<elements.length;j++){
                 elements[j]=temp[j-1];
             }
         }

    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        Object old;
        if (elements.length == 1){
            old=elements[0];
            elements = new Object[0];
        }else {
            old=elements[i];
            var temp = Arrays.copyOf(elements,elements.length);
            elements = new Object[elements.length-1];
            for (int j=0;j<i;j++){
                elements[j]=temp[j];
            }
            for (int j=i;j<elements.length;j++){
                elements[j]=temp[j+1];
            }
        }

        return old;
    }
}
