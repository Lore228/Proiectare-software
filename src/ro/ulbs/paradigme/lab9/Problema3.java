package ro.ulbs.paradigme.lab9;
import java.util.*;
import java.util.stream.*;

public class Problema3 {
    public static void main(String[] args) {
       String text="Acesta este un program scris cu java 8 si expresii lambda";
       List<String> cuvinte= Arrays.asList(text.split(" "));

       List<String> cuvlung=cuvinte.stream().filter(cuv->cuv.length()>=5).collect(Collectors.toList());
       System.out.println("Cuvinte care au mai multe de 5 litere: "+cuvlung);
       System.out.println("Numar cuvinte: "+cuvlung.size());

       List<String> listsort=cuvlung.stream().sorted().collect(Collectors.toList());
       System.out.println("Cuvinte ordonate: "+listsort);

       Optional<String> cuvCuP=cuvinte.stream().filter(cuv->cuv.startsWith("p")).findFirst();
       cuvCuP.ifPresentOrElse(
               cuv->System.out.println("Primul cuvant care incepe cu 'p': "+cuv),
               ()->System.out.println("Nu exista cuvinte care incep cu 'p'")
       );
    }
}
