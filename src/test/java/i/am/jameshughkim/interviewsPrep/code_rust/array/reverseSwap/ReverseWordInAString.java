package i.am.jameshughkim.interviewsPrep.code_rust.array.reverseSwap;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Given a sentence, reverse string in each word
 * <p>
 * "Hello World" => "olleH dlroW"
 */

public class ReverseWordInAString {
    static void reverse(char[] a, int s, int e) {
        int mid = s + (e - s) / 2;

        for (int i = s, j = e; i <= mid; i++, j--) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    static void reverseWords(char[] s) {
        if (s == null || s.length <= 1) return;

        //reverse(s, 0, s.length - 1);
        int startPtr = 0, endPtr = 0;

        while (true) {
            // if blank, increment startPtr
            while (s[startPtr] == ' ') startPtr++;
            if (startPtr == s.length) return;

            // if no more blank, initialize endPtr to startPtr
            endPtr = startPtr;

            while (endPtr < s.length - 2 && s[endPtr+1] != ' ') endPtr++;

            reverse(s, startPtr, endPtr);

            endPtr = endPtr+1;
            startPtr = endPtr;

            if (endPtr == s.length - 1) return;
        }
    }

    /***************
     * Pair
     ****************/

    static Stream<Pair<String, String>> testCases2() {
        return Stream.of(
                Pair.of("ab bc cd", "ba cb dc"),
                Pair.of("abc", "cba"),
                Pair.of("", ""),
                Pair.of(" abc d", " cba d")
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases2")
    void test(Pair<String, String> testCase) {
        char[] a = testCase.getFirst().toCharArray();
        String expected = testCase.getSecond();

        reverseWords(a);

        Assertions.assertEquals(expected, new String(a));
    }
}
