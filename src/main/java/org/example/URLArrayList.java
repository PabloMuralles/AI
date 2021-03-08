package org.example;

import java.util.Arrays;
import java.util.Objects;

public class URLArrayList implements List {

    private Object[] elements;
    private int size;

    @Override
    public int size() {return this.size;}

    @Override
    public boolean isEmpty() {return this.size==0;}

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
             var temp = Arrays.copyOf(elements,elements.length);
             temp[temp.length-1]=o;
             System.arraycopy(temp,temp.length-1,elements,i,1);
         }

    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        return null;
    }
}
