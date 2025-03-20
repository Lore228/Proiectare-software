package ro.ulbs.paradigme.lab4;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            x.add(rand.nextInt(11));
        }
        for (int i = 0; i < 7; i++) {
            y.add(rand.nextInt(11));
        }
        Collections.sort(x);
        Collections.sort(y);

        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        Set<Integer> zSet = new TreeSet<>(x);
        zSet.retainAll(y);

        List<Integer> xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y);

        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();
        for (Integer val : xPlusY) {
            if (val <= p) {
                xPlusYLimitedByP.add(val);
            }

        }
        System.out.println("Lista x: " + x);
        System.out.println("Lista y: " + y);
        System.out.println("xPlusY: " + xPlusY);
        System.out.println("zSet: " + zSet);
        System.out.println("xMinusY: " + xMinusY);
        System.out.println("xPlusYLimitedByP: " + xPlusYLimitedByP);
    }
}
