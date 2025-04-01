package ro.ulbs.paradigme.lab5;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("in.txt"));

            List<String> linesWithNewLine = addNewLineAfterEachLine(lines);
            System.out.println("Rezultatul dupa adaugarea unui newline la sfarsitul fiecarei linii: ");
            linesWithNewLine.forEach(System.out::println);

            String text = String.join(" ", lines);
            List<String> linesWithNewLineAfterDot = addNewLineAfterEachDot(text);
            System.out.println("\nRezultatul dupa adaugarea unui newline dupa fiecare punct: ");
            linesWithNewLineAfterDot.forEach(System.out::println);

            writeToFile("out.txt", linesWithNewLine,linesWithNewLineAfterDot);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    static List<String> addNewLineAfterEachLine(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            result.add(line+"\n");
        }
        return result;
    }

    static List<String> addNewLineAfterEachDot(String text) {
        List<String> result = new ArrayList<>();
        String[] sentences=text.split("(?<=\\.)");
        for(String sentence:sentences){
            result.add(sentence.trim()+"\n");
        }
        return result;
    }
    static void writeToFile(String fileName,List<String> linesWithNewLine, List<String> linesWithNewLineAfterDot) throws IOException {
        Path path = Paths.get(fileName);
        List<String> allLines = new ArrayList<>();
        allLines.add("Rezultatul cu newline la sfârșitul fiecărei linii:");
        allLines.addAll(linesWithNewLine);
        allLines.add("\nRezultatul cu newline după fiecare punct:");
        allLines.addAll(linesWithNewLineAfterDot);
        Files.write(path, allLines);
    }
}
