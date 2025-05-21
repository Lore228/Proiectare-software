package ro.ulbs.paradigme.lab9;
import java.util.*;
import java.util.stream.*;

public class Problema1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list=random.ints(10, 5, 26).boxed().collect(Collectors.toList());
        System.out.println("List: "+list);

        int suma=list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma: "+suma);

        int max=list.stream().mapToInt(Integer::intValue).max().orElseThrow();
        int min=list.stream().mapToInt(Integer::intValue).min().orElseThrow();
        System.out.println("Maxim: "+max);
        System.out.println("Minim: "+min);

        List<Integer> listafiltrata=list.stream().filter(n-> n>=10 && n<=20).collect(Collectors.toList());
        System.out.println("Elemenete in intervalul[10,20]: "+listafiltrata);

        List<Double> listadouble=list.stream().map(Integer::doubleValue).collect(Collectors.toList());
        System.out.println("Lista Double: "+listadouble);

        boolean ok=list.contains(12);
        System.out.println("Lista contine valoarea 12? "+ok);
    }
}
