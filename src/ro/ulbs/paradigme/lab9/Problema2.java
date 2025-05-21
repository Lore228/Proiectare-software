package ro.ulbs.paradigme.lab9;

import java.util.*;
import java.util.stream.*;

public class Problema2 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(9,10,3,4,7,3,4);
        List<Integer> list2=list.stream().distinct().map(n->n*n).collect(Collectors.toList());
        System.out.println("Lista: "+list);
        System.out.println("Lista modificata: "+list2);
    }
}
