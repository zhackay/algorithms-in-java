package cheat;

import i.am.jameshughkim.interviewsPrep.testUtils.Quadruple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * <h1>Find Smallest Common Number</h1>
 * Given three integers sorted in ascending order, find the smallest number that is common in all three arrays
 * <p>
 */
public class FindSmallestCommonNumberTest {

    // this is even more simpler and better
    int findSmallestCommonNumber(int[] a, int[] b, int [] c){
        int i=0, j=0, k=0;

        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) return a[i];
            if (a[i] < b[j]) i++;
            else if (b[j] < c[k]) j++;
            else if (c[k] < a[i]) k++;
        }
        return Integer.MIN_VALUE;
    }


    // My Solution - This is better
    int findSmallestCommonNumber3(int[] a, int[] b, int [] c) {
        int i=0, j=0, k=0;

        while (i<a.length && j<b.length && k<c.length) {
            if (a[i] == b[j] && b[j] == c[k]) return a[i];

            int max = Math.max(Math.max(a[i], b[j]), c[k]);

            while(i<a.length && a[i] < max) i++;
            while(j<b.length && b[j] < max) j++;
            while(k<c.length && c[k] < max) k++;

        }
        return Integer.MIN_VALUE;
    }

    // CR Solution
    int findSmallestCommonNumber2(int[] a, int[] b, int [] c) {
        int i=0, j=0, k=0;

        while (i<a.length && j<b.length && k<c.length) {
            if (a[i] == b[j] && b[j] == c[k]) return a[i];

            if (a[i] <= b[j] &&     // Array하나만 봤을때, 그 값이 다른 Array들 보다 작으면 같아질때까지 올리기
                a[i] <= c[k]) i++;
            else
            if (b[j] <= a[i] &&
                b[j] <= c[k]) j++;
            else
            if (c[k] <= b[j] &&
                c[k] <= a[i]) k++;

        }
        return Integer.MIN_VALUE;
    }

    /**
     * TESTS
     */


    static Stream<Quadruple<int[], int[] ,int[], Integer>> testCases() {
        Quadruple<int[], int[] ,int[], Integer> testCase1 = Quadruple.of(
                new int[]{6,7,10,25,30,63,64},
                new int[]{-1,4,5,6,7,8,50},
                new int[]{1,6,10,14},
                6);
        Quadruple<int[], int[] ,int[], Integer> testCase2 = Quadruple.of(
                new int[]{1,3,4,5},
                new int[]{6,7,8,10},
                new int[]{2,9,12,45},
                Integer.MIN_VALUE);
        Quadruple<int[], int[] ,int[], Integer> testCase3 = Quadruple.of(
                new int[]{1,3,4,5},
                new int[]{1,3,4,5},
                new int[]{9},
                Integer.MIN_VALUE);
        return Stream.of(testCase1, testCase2, testCase3);
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Quadruple<int[], int[], int[],Integer> testCase) {
        int[] a = testCase.getFirst();
        int[] b = testCase.getSecond();
        int[] c = testCase.getThird();
        int expected = testCase.getFourth();

        Assertions.assertEquals(expected,
                findSmallestCommonNumber(a, b, c));
    }
}
