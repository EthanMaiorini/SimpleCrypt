import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {
    static int cryptChange = 0;

    ROT13(Character cs, Character cf) {

        cryptChange = (int) (cf) - (int) (cs);

    }

    ROT13() {

    }

    public static String crypt(String text) throws UnsupportedOperationException {
        char[] str = text.toCharArray();
        int diff;
        for (int x = 0; x < text.length(); x++) {
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
                } else if ((str[x] <= 122)) {
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
        result = result.concat(s.substring(0, start));
        return result;
    }

    public static void encryptFile(Path path1, Path path2) throws IOException {
        String enc = "";
        File mySonnet,file;
        try {
            mySonnet = new File(String.valueOf(path1));
            if (mySonnet.createNewFile()) {
                System.out.println("File created: " + mySonnet.getName());
            } else {
                System.out.println("File already exists.");
            }
            decryptFile(path1,path2);
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void decryptFile(Path path1,Path path2) throws IOException {
        String enc = "";
        File file;
        Scanner scanner = null;
        FileWriter myWriter = null;
        BufferedWriter buffWriter = null;
        try {
            file = new File(String.valueOf(path2));
            scanner = new Scanner(file);
            myWriter = new FileWriter(String.valueOf(path1));
            buffWriter = new BufferedWriter(myWriter);
            while (scanner.hasNextLine()) {
                enc = crypt(scanner.nextLine());
                buffWriter.write(enc + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }finally {
            buffWriter.close();
            myWriter.close();
            scanner.close();
        }
    }

    public static boolean compareFiles(Path file1, Path file2) throws IOException {
        BufferedReader firstFile = Files.newBufferedReader(file1);
        BufferedReader secondFile = Files.newBufferedReader(file2);
        String line1 ="",line2 ="";
        while ((line1 = firstFile.readLine()) != null) {
            line2 = secondFile.readLine();
            if((line2 == null) || (!line1.equals(line2)))
                return false;
        }
        if(secondFile.readLine() == null) {
            return true;
        }else return false;
    }
}