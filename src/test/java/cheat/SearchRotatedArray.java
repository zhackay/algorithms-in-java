package cheat;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.stream.Stream;

/**
 * <h1>Search Rotated Array</h1>
 * search a given number in a sorted array that has been rotated by some arbitrary number
 * Return index
 * If not found, return -1
 * <hint>
 *     2 Basic situations - For sorted half
 *     1) a[lo] < a[mid]
 *          AND a[lo] <= k < a[mid] : search left
 *     2) a[mid] < a[hi]
 *          AND a[mid] < k <= a[hi]: search right

 *     2 Additional situations - For unsorted half
 *     1) a[lo] > a[mid] search left
 *     2) a[hi] < a[mid] search right
 * </hint>
 */
public class SearchRotatedArray {
    static int searchRotatedArray(int[] a, int k, int lo, int hi) {
        if (lo > hi) return -1;

        int mid = lo + (hi-lo)/2;

        if (a[mid] == k) return mid;
        else if (a[mid] > a[lo] && a[lo] <= k && k < a[mid]) return searchRotatedArray(a, k, lo, mid-1);
        else if (a[mid] < a[hi] && a[mid] < k && k <= a[hi]) return searchRotatedArray(a, k, mid+1, hi);
        else if (a[mid] < a[lo]) return searchRotatedArray(a, k, lo, mid-1);
        else if (a[mid] > a[hi]) return searchRotatedArray(a, k, mid+1, hi);
        else return -1;
    }

    /*************
     * Wrapper+-
     *************/

    static int searchRotatedArray(int[] a, int k) {
        return searchRotatedArray(a, k, 0, a.length-1);
    }

    /*************
     * TESTS
     *************/

    static Stream<Triplet<int[], Integer, Integer>> testCases() {
        return Stream.of(
                Triplet.of(new int[]{10,1,3,6,8}, 6, 3),
                Triplet.of(new int[]{10,1,3,6,8}, 10, 0),
                Triplet.of(new int[]{5,7,11,12,13,14,15,1,2,3,4},4, 10),
                Triplet.of(new int[]{5,7,11,12,13,14,15,1,2,3,4},5, 0),
                Triplet.of(new int[]{5,7,11,12,13,14,15,1,2,3,4},15, 6),
                Triplet.of(new int[]{1,2,3,4,6},3, 2),
                Triplet.of(new int[]{7,1,5},6, -1)
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Triplet<int[], Integer, Integer> testCase) {
        int[] a = testCase.getFirst();
        int k = testCase.getSecond();
        int expected = testCase.getThird();

        Assertions.assertEquals(expected, searchRotatedArray(a, k));
    }
}
