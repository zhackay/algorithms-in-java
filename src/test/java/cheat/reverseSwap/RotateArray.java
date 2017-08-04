package cheat.reverseSwap;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Given an array of integers, rotate the array by k elements
 * (negative allowed, k can be > a.length
 *
 * "abcde" with 3 => cdeab
 *
 * hint: reverse
 */
public class RotateArray {
    /**
     * My Solution - too complicated
     */

    // CR solution is better
    void reverse(int[] a, int s, int e) {
        if (e==s) return;
        int mid = s + (e-s)/2;

        while (s <= e && s <= mid) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;e--;
        }
    }

    // Mine works, CR doesn't
    void rotateArray(int[] a, int k){
        if (a.length == 0) return; // the below op will throw exception if a.length == 0
        if (k > a.length || k*-1 > a.length)
                    k = k % a.length; // In case, k is bigger than length, only get the remainder
        if (k==0) return; // this needs to be here - wants to check the condition after the above ops
        if (k < 0) k = k + a.length;        // In case, k is negative, make it positive equivalent
                                            // (e.g. if length = 10, -1 is equivalent to 9)

        reverse(a, 0, a.length-1);
        reverse(a, 0, k-1);
        reverse(a, k, a.length-1);
    }


    /**
     * CR Solution - Wrong!!!
     */

    void reverse2(int[] a, int s, int e) {
        while (s < e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            ++s; ++e;
        }
    }

    void rotateArray2(int[] a, int k){
        int len = a.length;
        k %= a.length;
        if (k < 0) k += a.length;

        reverse2(a, 0, a.length-1);
        reverse2(a, 0, k-1);
        reverse2(a, k, a.length-1);
    }
    /***************
     * TESTS
     ****************/

    static Stream<Triplet<int[], Integer, int[]>> testCases3() {
        return Stream.of(
                Triplet.of(new int[]{1,2,3,4,5},0, new int[] {1,2,3,4,5}),
                Triplet.of(new int[]{},4, new int[] {}),
                Triplet.of(new int[]{1},3, new int[] {1}),
                Triplet.of(new int[]{1, 2, 3, 4, 5},3, new int[] {3,4,5,1,2}),
                Triplet.of(new int[]{1, 2, 3, 4, 5},-1, new int[] {2,3,4,5,1}),
                Triplet.of(new int[]{1, 2, 3, 4, 5},-21, new int[] {2,3,4,5,1}),
                Triplet.of(new int[]{1, 2, 3, 4, 5},1, new int[] {5,1,2,3,4}),
                Triplet.of(new int[]{1, 2, 3, 4, 5},5, new int[] {1,2,3,4,5})
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases3")
    void test(Triplet<int[], Integer, int[]> testCase) {
        int[] actual = testCase.getFirst();
        int k = testCase.getSecond();
        int[] expected = testCase.getThird();

        rotateArray(actual, k);

        Assertions.assertArrayEquals(expected, actual);
    }
}
