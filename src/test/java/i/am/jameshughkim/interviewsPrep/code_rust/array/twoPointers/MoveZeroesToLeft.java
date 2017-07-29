package i.am.jameshughkim.interviewsPrep.code_rust.array.twoPointers;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <h1>Move Zeroes to Left</h1>
 * Given an integer array, move all elements containing '0' to the left
 * while maintaining the order of other elements in the array
 */
public class MoveZeroesToLeft {

    static void moveZeroesToLeft(int[] a) {
        int writePtr;
        int readPtr = writePtr = a.length-1;

        while (readPtr >= 0) {
            if (a[readPtr] != 0) {
                a[writePtr] = a[readPtr];
                writePtr--; readPtr--;
            } else {
                readPtr--;
            }
        }
        while (writePtr >= 0) {
            a[writePtr] = 0;
            writePtr--;
        }
    }

    /*************
     * TESTS
     *************/

    static Stream<Pair<int[], int[]>> testCases() {
        return Stream.of(
                Pair.of(new int[]{0,1,2,3,4,0,1,2,3}, new int[]{0,0,1,2,3,4,1,2,3}),
                Pair.of(new int[]{0,0,0,0}, new int[]{0,0,0,0}),
                Pair.of(new int[]{1,1,1,0,0,0,0}, new int[]{0,0,0,0,1,1,1}),
                Pair.of(new int[]{1,1,1,2,2,2,3}, new int[]{1,1,1,2,2,2,3}),
                Pair.of(new int[]{1,0,1,0,1,0,1}, new int[]{0,0,0,1,1,1,1}),
                Pair.of(new int[]{0}, new int[]{0}),
                Pair.of(new int[]{1}, new int[]{1}),
                Pair.of(new int[]{}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Pair<int[], int[]> testCase) {
        int[] actual = testCase.getFirst();
        int[] expected = testCase.getSecond();

        moveZeroesToLeft(actual);

        Assertions.assertArrayEquals(expected, actual);
    }
}
