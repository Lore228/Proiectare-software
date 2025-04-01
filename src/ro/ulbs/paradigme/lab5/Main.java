package ro.ulbs.paradigme.lab5;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Path inputPath = Paths.get("in.txt");
            String content = new String(Files.readAllBytes(inputPath));

            String textAfterLineBreak = content.replace("\n", "\n\n");
            System.out.println("Text după adăugarea unui newline pentru fiecare linie:\n");
            System.out.println(textAfterLineBreak+"\n");

            String[] parts = content.split("\\.");
            StringBuilder textWithNewlinesForDots = new StringBuilder();

            for (String part : parts) {
                textWithNewlinesForDots.append(part.trim());
                textWithNewlinesForDots.append(".\n");
            }

            System.out.println("Text după adăugarea unui newline pentru fiecare punct:");
            System.out.println(textWithNewlinesForDots+"\n");

            Path outputPath = Paths.get("out.txt");
            try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
                writer.write("Text cu newline după fiecare linie:");
                writer.write(textAfterLineBreak);
                writer.write("\n\n");

                writer.write("Text cu newline după fiecare punct:");
                writer.write(textWithNewlinesForDots.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
