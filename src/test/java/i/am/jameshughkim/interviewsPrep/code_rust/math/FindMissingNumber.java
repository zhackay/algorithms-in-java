package i.am.jameshughkim.interviewsPrep.code_rust.math;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <h1>Find Missing Number</h1>
 * Given an array of positive numbers from 1 to n, such that all numbers from 1 to n are present except one.
 * Find the missing number
 * <p>
 */
class FindMissingNumber {
    int findMissingNumbers(int[] a) {
        if (a.length <= 1 ) return -1;
        Arrays.sort(a);
        for (int i=1;i<a.length;i++) {
            if (a[i-1] - a[i] != 1) return a[i] - 1;
        }
         return 0;
    }

    static Stream<Pair<int[], Integer>> testCases() {
        Pair<int[], Integer> testCase1 = Pair.of(new int[]{1,3,4,5}, 2);
        Pair<int[], Integer> testCase2 = Pair.of(new int[]{9,8,5,6,10}, 7);
        Pair<int[], Integer> testCase3 = Pair.of(new int[]{3,1}, 2);

        return Stream.of(testCase1, testCase2, testCase3);
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Pair<int[], Integer> testCase) {
        int[] numAry = testCase.getFirst();
        int expected = testCase.getSecond();

        Assertions.assertEquals(expected,
                findMissingNumbers(numAry));
    }
}
