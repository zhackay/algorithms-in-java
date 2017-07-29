package i.am.jameshughkim.interviewsPrep.code_rust.array.divideAndConquer;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Merge {


    int[] merge(int[] a1, int[] a2) {
        int i=0, j=0, k=0;
        int[] merged = new int[a1.length + a2.length];

        while(i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                merged[k++] = a1[i++];
            }
            else {
                merged[k++] = a2[j++];
            }
        }

        while (i < a1.length) merged[k++] = a1[i++];
        while (j < a2.length) merged[k++] = a2[j++];

        return merged;
    }

    /***************
     * Tests
     ****************/

    static Stream<Triplet<int[], int[], int[]>> arrayTestCases() {
        return Stream.of(
                Triplet.of(new int[]{}, new int[]{1,2,3},
                        new int[]{1,2,3}),
                Triplet.of(new int[]{1, 2, 3, 4, 5},new int[]{},
                        new int[]{1, 2, 3, 4, 5}),
                Triplet.of(new int[]{3},new int[]{},
                        new int[]{3}),
                Triplet.of(new int[]{1, 2, 3},new int[]{5, 6},
                        new int[]{1,2,3,5,6}),
                Triplet.of(new int[]{1, 4, 12},new int[]{5, 6},
                        new int[]{1,4,5,6,12}),
                Triplet.of(new int[]{1, 3,5,7,9},new int[]{2,4,6,8},
                        new int[]{1,2,3,4,5,6,7,8,9}));
    }

    @ParameterizedTest
    @MethodSource(names = "arrayTestCases")
    void test(Triplet<int[], int[], int[]> testCase) {
        int[] a1 = testCase.getFirst();
        int[] a2 = testCase.getSecond();

        int[] expected = testCase.getThird();

        Assertions.assertArrayEquals(expected, merge(a1,a2));
    }
}
