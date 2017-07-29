package i.am.jameshughkim.interviewsPrep.code_rust.array.binarySearch;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given a sorted array of integers, return the low and high index of the given key.
 * Return -1 if not found.
 * The array length can be millions with lots of duplicates
 */
public class FindLoHiIndex {
    // findLowIndex & findHighIndex

    static int[] findLowHiIndex2(int[] a, int k) {
        return new int[] {
                findLoIndex(a, k, 0, a.length-1),
                findHiIndex(a, k, 0, a.length-1)
        };
    }

    static int mid(int lo, int hi) {
        return lo + (hi-lo)/2;
    }

    static int findLoIndex(int[] a, int k, int lo, int hi) {
        int mid = mid(lo, hi);

        while (lo <= hi) {
            if (a[mid] < k) lo = mid+1;
            else hi = mid-1;

            mid = mid(lo, hi);
        }

        if (a[lo] == k) return lo;

        return  -1;
    }

    static int findHiIndex(int[] a, int k, int lo, int hi) {
        int mid = mid(lo, hi);

        while (lo <= hi) {
            if (a[mid] <= k) lo = mid+1;
            else hi = mid-1;

            mid = mid(lo, hi);
        }

        if (a[hi] == k) return hi;

        return  -1;
    }


    /*************
     * My Solution - Which is wrong
     *************/

    static int[] findLowHiIndex1(int[] a, int k) {
        int index = find(a, k, 0, a.length-1); //3
        if (index == -1) return new int[] {-1, -1};

        int lo = findLow(a, k, 0, index);
        int hi = findHi(a, k, index, a.length-1);

        return new int[]{lo, hi};
    }

    static int find(int[] a, int k, int lo, int hi) {
        if (hi < lo) return -1;
        int mid = lo + (hi-lo)/2;
        if (k==a[mid]) return mid;
        if (k < a[mid]) return find(a, k, 0, mid-1);
        else return find(a, k, mid+1, hi);
    }

    static int findLow(int[] a, int k, int lo, int hi) {
        if (lo > hi) return -1;

        int mid = lo + (hi-lo)/2;

        if (a[mid] < k) lo = mid+1;
        else hi = mid-1;


        if (mid == 0) return mid;
        if (a[mid] == k && a[mid-1] < k) return mid;
        if (a[mid] < k) return findLow(a, k, a[mid+1], hi);
        if (k < a[mid])return findLow(a, k, lo, a[mid-1]);

        return -1;
    }

    static int findHi(int[] a, int k, int lo, int hi) {
        int mid = lo + (hi-lo)/2;
        if (mid == a.length-1) return mid;
        if (a[mid] == k && a[mid+1] > k) return mid;
        if (a[mid] > k) return findHi(a, k, lo, a[mid-1]);
        return findHi(a, k, a[mid+1], hi);
    }


    /*************
     * CR Solution
     *************/

    static int[] findLowHiIndex(int[] a, int k) {
        List<Integer> aList = toArrayList(a);
        return new int[] {find_low_index(aList, k), find_high_index(aList, k)};
    }

    static List<Integer> toArrayList(int[] a) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < a.length; index++)
        {
            intList.add(a[index]);
        }
        return intList;
    }


    static int find_low_index(List<Integer> arr, int key) {

        int low = 0;
        int high = arr.size()-1;
        int mid = high/2;

        while (low <= high) {

            int mid_elem = arr.get(mid);

            if (mid_elem < key) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

            mid = low + (high-low)/2;
        }

        if (arr.get(low) == key) {
            return low;
        }

        return -1;
    }

    static int find_high_index(List<Integer> arr, int key) {

        int low = 0;
        int high = arr.size()-1;
        int mid = high/2;

        while (low <= high) {

            int mid_elem = arr.get(mid);

            if (mid_elem <= key) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

            mid = low + (high-low)/2;
        }

        if (arr.get(high) == key) {
            return high;
        }

        return -1;
    }

    /*************
     * TESTS
     *************/

    static Stream<Triplet<int[], Integer, int[]>> testCases() {
        return Stream.of(
                Triplet.of(new int[]{3,3,3,3},3, new int[] {0, 3}),
                Triplet.of(new int[]{1, 2, 3, 4, 4, 4, 5},4, new int[] {3, 5}),
                Triplet.of(new int[]{1, 2, 3, 4, 4, 5},4, new int[] {3, 4}),
                Triplet.of(new int[]{3},3, new int[] {0, 0}),
                Triplet.of(new int[]{1, 2, 3, 4, 4, 4, 5},6, new int[] {-1, -1}),
                Triplet.of(new int[]{1, 1, 3, 4, 4, 4, 5},1, new int[] {0, 1}),
                Triplet.of(new int[]{1, 1, 3, 4, 4, 4, 5, 5},5, new int[] {6, 7})
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Triplet<int[], Integer, int[]> testCase) {
        int[] a = testCase.getFirst();
        int k = testCase.getSecond();
        int[] expected = testCase.getThird();

        Assertions.assertArrayEquals(expected, findLowHiIndex(a, k));
    }
}
