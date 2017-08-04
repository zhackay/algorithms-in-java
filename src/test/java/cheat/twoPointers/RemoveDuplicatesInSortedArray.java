package cheat.twoPointers;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

// Lo/hi Index and Read/Write Ptr
public class RemoveDuplicatesInSortedArray {

    int[] removeDuplicates(int[] a) {
        if (a.length <= 1) return a;
        int readPtr = 0, writePtr = 0;

        while (readPtr < a.length-1) {
            if (a[readPtr] != a[readPtr+1]) writePtr++;
            readPtr++;
            a[writePtr] = a[readPtr];
        }

        int[] ret = new int[writePtr+1];
        for(int i=0;i<ret.length;i++) {
            ret[i] = a[i];
        }

        return ret;
    }

    /***************
     * TESTS
     ****************/

    static Stream<Pair<int[], int[]>> testCases2() {
        return Stream.of(
                Pair.of(new int[]{}, new int[]{}),
                Pair.of(new int[]{1,1,1,1}, new int[]{1}),
                Pair.of(new int[]{1,2,3,3,4}, new int[]{1,2,3,4}),
                Pair.of(new int[]{1,1,2,2,3,4,4}, new int[]{1,2,3,4})
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases2")
    void test(Pair<int[], int[]> testCase) {
        int[] tc = testCase.getFirst();
        int[] expected = testCase.getSecond();

        Assertions.assertArrayEquals(expected, removeDuplicates(tc));
    }

}
