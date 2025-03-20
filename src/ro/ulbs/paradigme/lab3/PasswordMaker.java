package ro.ulbs.paradigme.lab3;
public class PasswordMaker {
    private static final int MAGIC_NUMBER=7;
    private final String magicString;
    private static PasswordMaker instance;
    private static int counter=0;

    private PasswordMaker(String name) {
        this.magicString=StringRandomizer.generateRandomString(20);
    }

    static {
        instance=null;
    }

    public static PasswordMaker getInstance(String name) {
        if(instance==null) {
            instance=new PasswordMaker(name);
            counter++;
        }
        return instance;
    }

    public String getPassword(String name) {
        String randomString=StringRandomizer.generateRandomString(MAGIC_NUMBER);
        String randomMagicString=generateRandomFromMagicString();
        String nameLength=String.valueOf(name.length());
        int randomNumber=(int)(Math.random()*51);

        return randomString+randomMagicString+nameLength+randomNumber;
    }

    private String generateRandomFromMagicString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            int index=(int)(Math.random()*magicString.length());
            sb.append(magicString.charAt(index));
        }
        return sb.toString();
    }

    public static int getCounter() {
        return counter;
    }

}
