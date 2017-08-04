package cheat.twoPointers;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveWhiteSpace {
    static String removeWhiteSpace(String s) {
        return removeWhiteSpace(s.toCharArray()) ;
    }

    static boolean isWhiteSpace(char c) {
        return c == ' ';
    }

    static String removeWhiteSpace(char[] s) {
        int readPtr = 0, writePtr = 0;

        while (readPtr < s.length) {
            if (isWhiteSpace(s[readPtr])) readPtr++;
            else {
                s[writePtr] = s[readPtr];
                readPtr++; writePtr++;
            }
        }

        return new String(s, 0, writePtr);
    }

    /***************
     * TESTS
     ****************/

    static Stream<Pair<String, String>> testCases2() {
        return Stream.of(
                Pair.of("hello everyone! how are you?", "helloeveryone!howareyou?"),
                Pair.of("", ""),
                Pair.of("  a", "a"),
                Pair.of("a   ", "a"),
                Pair.of("a  a", "aa")
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases2")
    void test(Pair<String, String> testCase) {
        String tc = testCase.getFirst();
        String expected = testCase.getSecond();

        Assertions.assertEquals(expected, removeWhiteSpace(tc.toCharArray()));
    }
}
