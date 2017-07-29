package i.am.jameshughkim.interviewsPrep.code_rust.array.binarySearch;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <h1>Binary Search</h2>
 * Given a sorted array of integer, return the index of the given key.
 * Return -1, if not found
 */
public class BinarySearch {

    public static int search(int[] a, int k, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi -lo)/2;

        if (k < a[mid]) return search(a, k, lo, mid-1);
        if (k > a[mid]) return search(a, k, mid+1, hi);
        return mid;
    }

    static int search2(int[] a, int k, int lo, int hi) {
        if (hi < lo) return -1;
        int mid = lo + (hi-lo)/2;

        if (k == a[mid]) return mid;
        else if (k < a[mid]) return search(a, k, 0, mid -1);
        return search(a, k, mid + 1, hi);
    }

    /*************
     * Wrapper
     *************/

    static int search(int[] a, int k) {
        return search(a, k, 0, a.length - 1);
    }

    /*************
     * TESTS
     *************/

    static Stream<Triplet<int[], Integer, Integer>> testCases() {
        return Stream.of(
                Triplet.of(new int[]{1,3,4,5}, 5, 3),
                Triplet.of(new int[]{1}, 1, 0),
                Triplet.of(new int[]{0,3,4,5,6,7}, 1, -1));
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Triplet<int[], Integer, Integer> testCase) {
        int[] a = testCase.getFirst();
        int k = testCase.getSecond();
        int expected = testCase.getThird();

        Assertions.assertEquals(expected, search(a, k));
    }
}