package i.am.jameshughkim.interviewsPrep.companies._1_expedia.algorithms.array.permutations;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


// https://stackoverflow.com/questions/28595428/find-every-possible-subset-given-a-string
// Todo: This link above has every variations(Recursive, Bitwise, Permutation using pre) of solution - Read it
public class AllSubset {

    List<HashSet<Integer>> getAllSubsetBitWise(int[] set) {

        throw new NotImplementedException();
    }

    List<String> getAllSubsetBitWise(String s) {
        throw new NotImplementedException();
    }

    /**
     * Solution - Bitwise approach
     */

    int getBits(int num, int bit) {
        return (((1 << bit) & num) == 0) ? 0 : 1;
    }

    // using bitManip
    List<HashSet<Integer>> getAllSubsetBitWise2(int[] set) {
        List<HashSet<Integer>> allSubsets = new ArrayList<>();
        // size of a set = 2^n;
        // if set={1,2,3}, then, it has 2^3 = 8 subsets
        int n = (int)Math.pow(2, set.length);

        for (int i=0; i<n;i++) { // for all subset slot
            HashSet<Integer> subset = new HashSet<>();
            for (int j = 0; j < set.length; j++) { // for each characters in a string
                if (getBits(i, j) == 1)
                    subset.add(set[j]);
            }
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    List<String> getAllSubsetBitWise2(String s) {
        List<String> allSubsets = new ArrayList<>();

        // size of a set = 2^n;
        // if s="abc", then, it has 2^3 = 8 subsets
        int n = (int)Math.pow(2, s.length());

        for (int i=0; i<n;i++) { // for all subset slot
            List<Character> subset = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) { // for each characters in a string
                if (getBits(i, j) == 1)
                    subset.add(s.charAt(j));
            }
            allSubsets.add(subset.toString());
        }
        return allSubsets;
    }

    /**
     * Recursive approach
     */



    /**
     * Tests
     */

    @Test
    void testAllSubsetString() {
        List<String> allSubset = getAllSubsetBitWise("abc");
        for(String subset: allSubset) {
            System.out.println(subset);
        }
    }

    @Test
    void testAllSubsetInteger() {
        List<HashSet<Integer>> allSubset = getAllSubsetBitWise(new int[] {1,2,3});
        for(HashSet<Integer> subset: allSubset) {
            System.out.println(subset.toString());
        }
    }

}
