import junit.framework.TestCase;

import static org.testng.AssertJUnit.assertTrue;

public class CaesarTest extends TestCase {

    public void testCrypt() {
        Caesar cipher = new Caesar();

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);
        String result = "Zkb glg wkh fklfnhq furvv wkh urdg?";

        // When
        String actual = cipher.crypt(Q1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(result));
    }
}