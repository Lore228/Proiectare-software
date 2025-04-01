package ro.ulbs.paradigme.lab4;
import java.util.*;

public class Student {
    protected String name;
    private String surname;
    protected String group;
    private List<Integer> grades;

    public Student(String name, String surname, String group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.grades = new ArrayList<>();
        generateGrades();
    }

    public void generateGrades() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            grades.add(rand.nextInt(7)+4);
        }
    }

    public float getAverage() {
        int sum = 0;
        for(int grade: grades) {
            sum += grade;
        }
        return (float)sum/5;
    }

    public boolean isIntegralist(){
        for(int grade: grades) {
            if(grade < 5) {
                return false;
            }
        }
        return true;
    }

    public int getNumberOfFailures(){
        int failures = 0;
        for(int grade: grades) {
            if(grade < 5) {
                failures++;
            }
        }
        return failures;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && surname.equals(student.surname)&& group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, group);
    }

    @Override
    public String toString() {
        return name + " " + surname + " Group " + group + " Grades: " + grades.toString();
    }
}

