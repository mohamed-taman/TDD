/*
 * MIT License
 *
 *     Copyright (c) 2019  Mohamed Mahmoud Taman - Sirius-X Innovations
 *
 *     Permission is hereby granted, free of charge, to any person obtaining a copy
 *     of this software and associated documentation files (the "Software"), to deal
 *     in the Software without restriction, including without limitation the rights
 *     to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *     copies of the Software, and to permit persons to whom the Software is
 *     furnished to do so, subject to the following conditions:
 *
 *     The above copyright notice and this permission notice shall be included in all
 *     copies or substantial portions of the Software.
 *
 *     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *     FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *     SOFTWARE.
 */

package rs.com.tm.siriusxi.tdd.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rs.com.tm.siriusxi.tdd.roman.RomanConverter.convertRomanToArabicNumber;

/**
 * Test class, to validate the working mechanism of Roman converter class.
 *
 * @author mohamed_taman
 * @since 1.0
 */
class RomanConverterTest {

    @Test
    void convertI() {
        assertEquals(1, convertRomanToArabicNumber("I"),
                "Roman I should equal to 1");
    }

    @Test
    void convertII() {
        assertEquals(2, convertRomanToArabicNumber("II"),
                "Roman II should equal to 2");
    }

    @Test
    void convertIII() {
        assertEquals(3, convertRomanToArabicNumber("III"),
                "Roman III should equal to 3");
    }

    @Test
    void convertV() {
        assertEquals(5, convertRomanToArabicNumber("V"),
                "Roman V should equal to 5");
    }

    @Test
    void convertVI() {
        assertEquals(6, convertRomanToArabicNumber("VI"),
                "Roman VI should equal to 6");
    }

    @Test
    void convertIV() {
        assertEquals(4, convertRomanToArabicNumber("IV"),
                "Roman IV should equal to 4");
    }

    @Test
    void convertX() {
        assertEquals(10, convertRomanToArabicNumber("X"),
                "Roman X should equal to 10");
    }

    @Test
    void convertIX() {
        assertEquals(9, convertRomanToArabicNumber("IX"),
                "Roman IX should equal to 9");
    }

    @Test
    void convertXXXVI() {
        assertEquals(36, convertRomanToArabicNumber("XXXVI"),
                "Roman XXXVI should equal to 36");
    }

    @Test
    void convertMMXII() {
        assertEquals(2012, convertRomanToArabicNumber("MMXII"),
                "Roman MMXII should equal to 2012");
    }

    @Test
    void convertMCMXCVI() {
        assertEquals(1996, convertRomanToArabicNumber("MCMXCVI"),
                "Roman MCMXCVI should equal to " +
                        "1996");
    }

    @Test
    void convertInvalidRomanValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> convertRomanToArabicNumber("Z"),
                "Invalid roman character Z Should throw (IllegalArgumentException)");
    }

    @Test
    void convertVII() {
        assertEquals(7, convertRomanToArabicNumber("vii"),
                "Roman VII should equal to 7");
    }
}
