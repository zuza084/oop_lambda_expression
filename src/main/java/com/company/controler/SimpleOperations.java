package com.company.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleOperations {
    private int [] numbers = {2,1,34,21,21,2,3,4,5,6,7,8,9,12,56};
    public int getMaxValue(){
        return Arrays.stream (numbers)
               // .sorted(num1, num2) -> num2.compareto(num1))
.max().getAsInt ();
    }
    public int getMinValue(){
        return Arrays.stream (numbers)
                // .sorted(num1, num2) -> num2.compareto(num1))
                .min().getAsInt ();
    }
    public double getAvg (){
        return Arrays.stream(numbers)
                .average ().getAsDouble ();
    }
    public void getElementsGreaterThanAvg(){
        System.out.printf ("Elementy większe od średniej: %s%n", Arrays.stream (numbers)
                .filter (number -> number > getAvg ( ))
                .mapToObj (Integer::new)
                .sorted (Comparator.reverseOrder ( ))
                .map (number -> number.toString ( ))
                .collect (Collectors.joining (",")));
    }
    public static void main(String[] args){
        SimpleOperations so = new SimpleOperations ();
        System.out.println ("MAX" + so.getMaxValue() );
        System.out.println ("MIN" + so.getMinValue() );
        System.out.println ("AVG" + so.getAvg () );
        so.getElementsGreaterThanAvg ();
    }
}
