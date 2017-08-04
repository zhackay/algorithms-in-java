package cheat;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeSort {

    void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return; // todo: there is an equal!!
        int mid = lo + (hi-lo)/2; // mid, or, mid+1

        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge5(a, lo, mid, hi);
    }

    void merge(int a[], int left, int mid, int right) {
        int i=left, j=mid+1, k=0;
        int[] b = new int[right-left];

        while (i < mid && j < right) { // not <=, but, <, why? because the body will execute until
            if (a[i] <= a[j]) b[k++] = a[i++];
            else b[k++] = a[j++];
        }

        while (i <= mid) b[k++] = a[i++];
        while (j <= right) b[k++] = a[j++];
        i=left; k=0;
        while(i<=right) b[k++] = a[i++];
    }

    void merge3(int a[], int left, int mid, int right) {
        int[] temp = new int[right-left];

        int i=left, j=mid+1, k=0;
        while (i < j) {
            if (a[i] < a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }

        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];

        i = left; k=0;
        for (k=0; k<temp.length; k++){
            a[i++] = a[k];
        }
    }

    /***************
     * Solution
     ****************/

    void merge5(int arr[], int left, int mid, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1; // todo: why + 1?
        int n2 = right - mid;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        // Copy data to temp arrays
        for (int i=0; i<n1; ++i) L[i] = arr[left + i];
        for (int j=0; j<n2; ++j) R[j] = arr[mid + 1 + j]; // todo: why + 1? (mid+1) is the first positon of second array

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }


    void sort5(int[] a, int lo, int hi) {
        if (hi <= lo) return; // todo: this has to be <= and not <
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    /***************
     * Wrapper
     ****************/

    void sort(int[] a) {
        sort(a, 0, a.length-1);
    }

    /***************
     * Tests
     ****************/

    static Stream<Pair<int[], int[]>> sortTestCases() {
        return Stream.of(
                Pair.of(new int[]{3,4,5,6}, new int[]{3,4,5,6}),
                Pair.of(new int[]{3, 9, 1, 12, 2, 4, 18},new int[]{1, 2, 3, 4, 9, 12, 18}),
                Pair.of(new int[]{3},new int[]{3}),
                Pair.of(new int[]{5,4,3,2,1},new int[]{1, 2, 3, 4, 5}));
    }

    @ParameterizedTest
    @MethodSource(names = "sortTestCases")
    void testSort(Pair<int[], int[]> testCase) {
        int[] actual = testCase.getFirst();
        int[] expected = testCase.getSecond();

        sort(actual);

        Assertions.assertArrayEquals(expected, actual);
    }



}
