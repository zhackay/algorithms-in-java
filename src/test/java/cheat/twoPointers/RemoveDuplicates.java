package cheat.twoPointers;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.stream.Stream;

/**
 * <h1>Remove duplicate characters from a string </h1>
 * Given a string that contains duplicate occurences, remove these duplicate occurrences
 *
 * For example, abbabcddbabcdeedebc -> abcde
 *
 * Hint: Still have to use read/writePtr
 *
 */
public class RemoveDuplicates {
    String removeDuplicates(char[] s){
        HashSet<Character> set = new HashSet<>();
        int readPtr = 0, writePtr = 0;
        while (readPtr < s.length) {
            if (!set.contains(s[readPtr])) { // first time
                set.add(s[readPtr]);
                s[writePtr++] = s[readPtr++]; // or, I can write
            }
            else {
                readPtr++;
            }
        }
        return new String(s, 0, writePtr);
        // it was kind of Okay - the signature for new String(char[] a, int offset, int count)
        // Why is the count writePtr? and not writePtr + 1
    }

    String removeDuplicates5(char[] s) {
        HashSet<Character> set = new HashSet<>();
        int readPtr = 0, writePtr = 0;

        while (readPtr < s.length) {
            if (!set.contains(s[readPtr])) {
                set.add(s[readPtr]);
                s[writePtr] = s[readPtr];
                readPtr++; writePtr++;
            }
            else {
                readPtr++;
            }
        }

        return new String(s, 0, writePtr);
    }

    /***************
     * TESTS
     ****************/

    static Stream<Pair<String, String>> testCases2() {
        return Stream.of(
                Pair.of("abbabcddbabcdeedebc", "abcde"),
                Pair.of("", ""),
                Pair.of("aaaa", "a")
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases2")
    void test(Pair<String, String> testCase) {
        String tc = testCase.getFirst();
        String expected = testCase.getSecond();

        Assertions.assertEquals(expected, removeDuplicates(tc.toCharArray()));
    }

}
