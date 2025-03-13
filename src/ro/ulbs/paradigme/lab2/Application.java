package ro.ulbs.paradigme.lab2;// Application.java
import ro.ulbs.paradigme.lab2.simplechained.SimpleChainedList;
import ro.ulbs.paradigme.lab2.doublechained.DoubleChainedList;

public class Application {
    public static void main(String[] args) {
        SimpleChainedList simpleList = new SimpleChainedList();
        for (int i = 1; i <= 10; i++) {
            simpleList.addValue(i);
        }
        simpleList.removeNodeByValue(4);
        simpleList.removeNodeByValue(6);
        simpleList.removeNodeByValue(8);
        simpleList.removeNodeByValue(10);
        System.out.println("Simple Chained List:");
        simpleList.listNodes();
        System.out.println("Sum: " + simpleList.sum());
        System.out.println("Is sorted: " + simpleList.isSorted());

        DoubleChainedList doubleList = new DoubleChainedList();
        for (int i = 1; i <= 10; i++) {
            doubleList.addValue(i);
        }
        doubleList.removeNodeByValue(1);
        doubleList.removeNodeByValue(2);
        doubleList.removeNodeByValue(3);
        System.out.println("Double Chained List:");
        doubleList.listNodes();
        System.out.println("Sum: " + doubleList.sum());
        System.out.println("Is sorted: " + doubleList.isSorted());
    }
}
