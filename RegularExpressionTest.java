package pl.kurs.regularne;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegularExpressionTest {

    @Test
    public void testClassWithMultipleRanges() {
        Pattern pattern = Pattern.compile("[a-cA-C0-3]bum");
        assertTrue(pattern.matcher("abum").matches());
        assertTrue(pattern.matcher("Bbum").matches());
        assertTrue(pattern.matcher("0bum").matches());
        assertFalse(pattern.matcher("dbum").matches());
        assertFalse(pattern.matcher("aA0bum").matches());
        assertFalse(pattern.matcher("aB1bum").matches());
        assertFalse(pattern.matcher("abbum").matches());
    }

    @Test
    public void testFloatNumberforCorrectness()
    {
        Pattern pattern = Pattern.compile("-*\\d+,*\\d+");
        assertTrue(pattern.matcher("123,2341515132135").matches());
        assertTrue((pattern.matcher("-10").matches()));
        assertFalse(pattern.matcher("18-12").matches());
        assertFalse(pattern.matcher("123,").matches());
        assertTrue(pattern.matcher("10").matches());
    }
}
