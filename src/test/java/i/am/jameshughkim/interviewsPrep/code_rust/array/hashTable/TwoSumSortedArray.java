package i.am.jameshughkim.interviewsPrep.code_rust.array.hashTable;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * <h1>Two Sum sorted</h1>
 * Given a sorted integer array and a value,
 * determine if there are any two integers in the array which sum equal to the given value
 */
public class TwoSumSortedArray {

    // search smaller from 0, bigger from length-1
    boolean twoSum(int[] a, int sum) {
        throw new NotImplementedException();
    }

    /*************
     * Solution
     *************/

    // O(n) / O(1)
    boolean TwoSumSortedArray(int[] a, int val) {
        for (int i = 0, j = a.length - 1; i < j;) {
            int sum = a[i] + a[j];
            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }

    /*************
     * TESTS
     *************/

    static Stream<Triplet<int[], Integer, Boolean>> testCases() {
        return Stream.of(
                Triplet.of(new int[]{1,2,6,12,14,17,33}, 18, true),
                Triplet.of(new int[]{1,2,3,4,5,6,7}, 0, false),
                Triplet.of(new int[]{}, 1, false),
                Triplet.of(new int[]{1,1,1,1}, 2, true)
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Triplet<int[], Integer, Boolean> testCase) {
        int[] input = testCase.getFirst();
        int sum = testCase.getSecond();
        boolean expected = testCase.getThird();

        Assertions.assertEquals(expected, TwoSumSortedArray(input, sum));
    }
}
