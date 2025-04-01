package ro.ulbs.paradigme.lab4;
import java.util.*;
import java.io.*;

public class Application {
    public static void main(String[] args) {
        Map<Student, Integer> students = readInputFile("input.txt");

        System.out.println("Students sorted alphabetically by group:");
        printStudentsSortedByGroup(students);

        List<Student> integralist=new ArrayList<>();
        List<Student> restantier=new ArrayList<>();
        for(Student student:students.keySet()){
            if(student.isIntegralist()){
                integralist.add(student);
            }else{
                restantier.add(student);
            }
        }
    System.out.println("\nStudents sorted by average grade(descending):");
        printIntegralistSortedByAverage(integralist);
        System.out.println("\nStudents sorted by number of failures(ascending):");
        printRestantierSortedByFailures(restantier);
    }

    static Map<Student, Integer> readInputFile(String fileName) {
        Map<Student, Integer> students = new HashMap<>();
        BufferedReader reader = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + file.getAbsolutePath());
                return students;
            }
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String firstName = parts[0];
                String lastName = parts[1];
                String group = parts[2];
                Student student = new Student(firstName, lastName, group);

                students.put(student, students.getOrDefault(student, 0) + 1);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return students;
    }

    static void printStudentsSortedByGroup(Map<Student, Integer> students) {
        List<Student> sortedStudents = new ArrayList<>(students.keySet());
        Collections.sort(sortedStudents, Comparator.comparing(Student::getGroup).thenComparing(Student::getName).thenComparing(Student::getSurname));
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
    }

    static void printIntegralistSortedByAverage(List<Student> integralist) {
        Collections.sort(integralist,(s1,s2)->Float.compare(s2.getAverage(), s1.getAverage()));
        for (Student student : integralist) {
            System.out.println(student+" Average "+student.getAverage());
        }
    }

    static void printRestantierSortedByFailures(List<Student> restantier) {
        Collections.sort(restantier, Comparator.comparingInt(Student::getNumberOfFailures));
        for (Student student : restantier) {
            System.out.println(student+" Failures "+student.getNumberOfFailures());
        }
    }
}