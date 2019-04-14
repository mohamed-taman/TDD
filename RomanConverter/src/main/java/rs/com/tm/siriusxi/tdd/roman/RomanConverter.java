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

import java.util.HashMap;
import java.util.Map;

/**
 * Class represents a roman converter to Arabic numbers.
 *
 * @author mohamed_taman
 * @since 1.0
 */
final class RomanConverter {

    /**
     * romanSymbols is a holder for each roman character as a key, and equivalent Arabic number as
     * value.
     */
    private static final Map<Character, Integer> romanSymbols = new HashMap<Character, Integer>() {
        private static final long serialVersionUID = 1L;

        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    private RomanConverter() {
    }

    /**
     * Method that takes a roman character(s), and returns equivalent Arabic number.
     *
     * @param roman character
     * @return equivalent Arabic representation.
     */
    static int convertRomanToArabicNumber(String roman) {

        roman = roman.toUpperCase();

        int sum = 0;
        int current = 0;
        int previous = 0;

        for (int index = roman.length() - 1; index >= 0; index--) {
            if (doesSymbolsContainsRomanCharacter(roman, index)) {

                current = getSymbolValue(roman, index);

                if (current < previous) {
                    sum -= current;
                } else {
                    sum += current;
                }

                previous = current;

            } else {
                throw new IllegalArgumentException(
                        String.format("Invalid roman character %s ", getCharValue(roman, index)));
            }
        }
        return sum;
    }

    private static boolean doesSymbolsContainsRomanCharacter(String roman, int index) {
        return romanSymbols.containsKey(getCharValue(roman, index));
    }

    private static Integer getSymbolValue(String roman, int index) {
        return romanSymbols.get(getCharValue(roman, index));
    }

    private static char getCharValue(String roman, int index) {
        return roman.charAt(index);
    }
}
