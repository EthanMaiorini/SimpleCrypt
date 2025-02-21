import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertTrue(actual2.equals(A2));
    }
    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));
    }



    @Test
    public void testEncyptFile() throws IOException {
        ROT13 cipher = new ROT13('a', 'n');
        Path path1 = Paths.get("/Users/ethan/dev/SimpleCrypt/sonnet18.txt");
        Path path2 = Paths.get("/Users/ethan/dev/SimpleCrypt/sonnet18.enc");
        cipher.decryptFile(cipher.createFile(path2),path1);
        assertTrue(cipher.compareFiles(path1,path2));
    }

    @Test
    public void testCreateFile() {
        ROT13 cipher = new ROT13('a', 'n');
        Path path2 = Paths.get("/Users/ethan/dev/SimpleCrypt/sonnet18.enc");
        Path path1 = cipher.createFile(path2);
        assertEquals(path1,path2);
    }

//    @Test
//    public void testDecryptFile() {
//        ROT13 cipher = new ROT13('a', 'n');
//        Path path1 = Paths.get("/Users/ethan/dev/SimpleCrypt/sonnet18.txt");
//        Path path2 = Paths.get("/Users/ethan/dev/SimpleCrypt/sonnet18.enc");
//
//
//    }
}