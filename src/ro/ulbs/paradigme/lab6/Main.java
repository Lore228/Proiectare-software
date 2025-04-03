package ro.ulbs.paradigme.lab6;

public class Main {
    public static void main(String[] args) {
        NewIntCalculator calculator = new NewIntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("5.4.2 a) " + result);
        DoubleCalculator fCalculator = new DoubleCalculator(10.0);
        double result2 =
               fCalculator.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("5.4.2 b) "+result2);
        double result3 =
                fCalculator.clear().add(10.0).subtract(3.3).multiply(2.2).result();
        System.out.println("5.4.2 b) "+result3);
    }
}
