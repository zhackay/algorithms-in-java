package i.am.jameshughkim.interviewsPrep.code_rust.array.permutation;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// todo: PrintPermute works, but listPermute doesn't. Why?
public class PermuteStrings {



    void permutePrint(String pre, String s) {
        if (s.length() == 0) {
            System.out.println(pre);
            return;
        }

        for (int i=0;i<s.length();i++) {
            pre += s.charAt(i);
            String rest = s.substring(0, i) + s.substring(i+1);
            permutePrint(pre, rest);
        }
    }


    @Test
    void permutePrint() {
        permutePrint("", "abc");
    }



    List<String> permute(String s) {
        List<String> pList = new ArrayList<>();
        permute("", s, pList);
        return pList;
    }

    void permute(String pre, String s, List<String> pList) {
        if (s.length() == 0) pList.add(pre);
        else {
            int len = s.length(); // todo: better to be outside of "for" condition, because s is mutating
            for (int i=0;i<len;i++) {
                pre += s.charAt(i);
                s = s.substring(0, i) // todo: ending index - exclusive
                        + s.substring(i+1);
                permute(pre, s, pList);
            }
        }
    }

    // O(n!) - simpler than codeRust solution
    // this is when duplicate doesn't exist
    void printPermute(String pre, String s) {
        if (s.length() == 0) System.out.println(pre);
        else
            for (int i=0;i<s.length();i++)
                printPermute(pre+s.charAt(i), s.substring(0, i) + s.substring(i+1));
    }

    // todo: when duplicate exists, it gets more complicated.
    // look at this article https://stackoverflow.com/questions/12667551/permutations-with-duplicates
    // to not only come up with solution with duplicate, but, also, with List<String>

    /***************
     * Tests
     ****************/

    static Stream<Pair<String, List<String>>> testCases2() {
        return Stream.of(
                Pair.of("abc", Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")),
                Pair.of("a", Arrays.asList("a")),
                Pair.of("", Arrays.asList("")),
                Pair.of("bbc", Arrays.asList("bbc", "cbb", "bcb"))
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases2")
    void test(Pair<String, List<String>> testCase) {
        String s = testCase.getFirst();
        List<String> expected = testCase.getSecond();

        Assertions.assertEquals(expected, permute(s));
    }

    @Test
    void testPrint() {
        printPermute("", "abc");
    }
}
