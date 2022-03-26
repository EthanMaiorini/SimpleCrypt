import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    static int cryptChange = 0;

    ROT13(Character cs, Character cf) {

        cryptChange = (int)(cf)-(int)(cs);

    }

    ROT13() {

    }

    public static String crypt(String text) throws UnsupportedOperationException {
        char[] str = text.toCharArray();
        int diff;
        for(int x =0;x<text.length();x++) {
            if ((str[x] <= 90) && (str[x] >= 65)) {
                if ((str[x] <= (90 - cryptChange)) && (str[x] >= 65)) {
                    diff = str[x] + cryptChange;
                    str[x] = ((char) diff);
                } else if ((str[x] <= 90) && (str[x] < 91)) {
                    str[x] = (char) (64 + (cryptChange - (90 - str[x])));
                }
            } else if ((str[x] <= 122) && (str[x] >= 97)) {
                if ((str[x] <= 122 - cryptChange) && (str[x] >= 97)) {
                    diff = str[x] + cryptChange;
                    str[x] = (char) diff;
                } else if ((str[x] <= 122)){
                    str[x] = (char) (96 + (cryptChange - (122 - str[x])));
                }
            } else str[x] = (str[x]);
        }
        return String.valueOf(str);
    }

    public String encrypt(String text) {
        text = crypt(text);
        return text;
    }

    public String decrypt(String text) {
        text = crypt(text);
        return text;
    }

    public static String rotate(String s, Character c) {
    int start = s.indexOf(c);
    String result = s.substring(start);
    result = result.concat(s.substring(0,start));
    return result;
    }

    public static void encryptFile() throws FileNotFoundException {
        String enc = "";
        try {
            File mySonnet = new File("/Users/ethan/dev/SimpleCrypt/sonnet18.enc");
            if (mySonnet.createNewFile()) {
                System.out.println("File created: " + mySonnet.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        File file = new File("/Users/ethan/dev/SimpleCrypt/sonnet18.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            enc = crypt(sc.next());
            try {
                FileWriter myWriter = new FileWriter("/Users/ethan/dev/SimpleCrypt/sonnet18.enc");
                myWriter.write(enc);

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
           // myWriter.close();
        }
    }
}
