package pl.kurs.regularne;

import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.PAData;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegularExpressionTest {

    @Test
    public void testFloatNumberforCorrectness()
    {
        Pattern pattern = Pattern.compile("-?\\d+,?\\d+");
        assertTrue(pattern.matcher("123,2341515132135").matches());
        assertTrue((pattern.matcher("-10").matches()));
        assertFalse(pattern.matcher("18-12").matches());
        assertFalse(pattern.matcher("123,").matches());
        assertTrue(pattern.matcher("10").matches());
        assertFalse(pattern.matcher("-----123").matches());
        assertFalse(pattern.matcher("123,123,123").matches());

    }

    @Test
    public void testProperHouseNumber()
    {
        Pattern pattern = Pattern.compile("\\d+\\D?\\\\\\d+\\D?");
        assertTrue(pattern.matcher("123\\2A").matches());
        assertTrue(pattern.matcher("24B\\3").matches());
        assertTrue(pattern.matcher("12\\5").matches());
        assertFalse(pattern.matcher("abc\\cba").matches());
        assertFalse(pattern.matcher("44\\c").matches());
        assertFalse(pattern.matcher("44\\c4").matches());
        assertFalse(pattern.matcher("12").matches());
    }

    @Test
    public void testProperCityName()
    {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+(( |-)[A-Z][a-z]+)?");
        assertTrue(pattern.matcher("Wroclaw").matches());
        assertTrue(pattern.matcher("Zielona Gora").matches());
        assertTrue(pattern.matcher("Bielsko-Biala").matches());
        assertFalse(pattern.matcher("Ptysiow123").matches());
        assertFalse(pattern.matcher("wroclaw").matches());
    }
}
