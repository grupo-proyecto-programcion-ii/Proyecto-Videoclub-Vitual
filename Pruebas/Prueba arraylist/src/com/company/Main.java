package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
// Declaración el ArrayList
        ArrayList<String> nombreArrayList = new ArrayList<String>();

// Añadimos 10 Elementos en el ArrayList
        for (int i=1; i<=10; i++){
            nombreArrayList.add("Elemento "+i);
        }

// Añadimos un nuevo elemento al ArrayList en la posición 2
        nombreArrayList.add(2, "Elemento 3");

// Declaramos el Iterador e imprimimos los Elementos del ArrayList
        Iterator<String> nombreIterator = nombreArrayList.iterator();
        while(nombreIterator.hasNext()){
            System.out.print(nombreIterator.next()+" / ");
        }
    }
}
