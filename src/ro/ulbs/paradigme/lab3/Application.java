package ro.ulbs.paradigme.lab3;

public class Application {
    public static void main(String[] args) {
        PasswordMaker passwordMaker1 =PasswordMaker.getInstance("Lorena");
        PasswordMaker passwordMaker2 =PasswordMaker.getInstance("Alina");

        System.out.println("Password 1: " + passwordMaker1.getPassword("Lorena"));
        System.out.println("Password 2: " + passwordMaker2.getPassword("Alina"));

        System.out.println("Identical? " + (passwordMaker1 == passwordMaker2));
        System.out.println("Number of times getInstance() was accessed: " + PasswordMaker.getCounter());



    }
}
