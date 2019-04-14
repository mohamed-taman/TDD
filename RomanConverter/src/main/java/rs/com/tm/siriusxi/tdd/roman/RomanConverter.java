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

import java.util.Map;

/**
 * Class represents a roman converter to Arabic numbers.
 *
 * @author mohamed_taman
 * @since 1.0
 */
class RomanConverter {

    /**
     * romanSymbols is a holder for each roman character as a key, and equivalent Arabic number as
     * value.
     */
    private Map<Character, Integer> romanSymbols =
            Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    /**
     * Method that takes a roman character(s), and returns equivalent Arabic number.
     *
     * @param roman character
     * @return equivalent Arabic representation.
     */
    int convertRomanToArabicNumber(String roman) {
        var sum = 0;
        var current = 0;
        var previous = 0;

        for (int index = 0; index < roman.length(); index++) {
            if (romanSymbols.containsKey(roman.charAt(index))) {
                current = romanSymbols.get(roman.charAt(index));
                previous = index == 0 ? 0 : romanSymbols.get(roman.charAt(index - 1));
                if (previous >= current) {
                    sum += current;
                } else {
                    sum -= previous;
                    sum += (current - previous);
                }
            } else {
                throw new IllegalArgumentException(
                        String.format("Invalid roman character %s ", roman.charAt(index)));
            }
        }
        return sum;
  }
}
