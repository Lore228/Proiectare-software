package ro.ulbs.paradigme.lab3;
import java.util.Random;

public class StringRandomizer {
    public static String generateRandomString(int length) {
        String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int nr=random.nextInt(characters.length());
            sb.append(characters.charAt(nr));
        }
        return sb.toString();
    }
}
