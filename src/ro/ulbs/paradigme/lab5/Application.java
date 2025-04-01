package ro.ulbs.paradigme.lab5;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            generateRandomWordsFile("outrand.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void generateRandomWordsFile(String fileName) throws IOException {
        Random rand = new Random();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            String word = generateRandomWord(4, rand);
            words.add(word);
        }

        Collections.sort(words);

        Path path = Paths.get(fileName);
        StringBuilder fileContent = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            fileContent.append(words.get(i));
            if ((i + 1) % 10 == 0) {
                fileContent.append("\n");
            } else {
                fileContent.append(" ");
            }
        }

        Files.write(path, fileContent.toString().getBytes());
    }

    static String generateRandomWord(int length, Random rand) {
        StringBuilder word = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char letter = (char) ('a' + rand.nextInt(26));
            word.append(letter);
        }
        return word.toString();
    }
}
