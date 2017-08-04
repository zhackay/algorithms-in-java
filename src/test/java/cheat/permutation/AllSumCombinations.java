package cheat.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer, print all possible sum combinations using positive integers.
 *
 * For example, if we are given input '5', these are the possible sum combinations.
         1, 4
         2, 3
         1, 1, 3
         1, 2, 2
         1, 1, 1, 2
         1, 1, 1, 1, 1
 */
public class AllSumCombinations {

    static void printAllPossibleSumCombinations(int target) {
        List<Integer> output = new ArrayList<Integer>();
        printAllPossibleSumCombinations(target, 0, 1, output);
    }

    static void printAllPossibleSumCombinations(int target, int current_sum, int start, List<Integer> output) {
        if (target == current_sum) print_list(output);

        for (int i = start; i < target; ++i) {
            int temp_sum = current_sum + i;
            if (temp_sum <= target) {
                output.add(i);
                printAllPossibleSumCombinations(target, temp_sum, i, output);
                output.remove(output.size() - 1);
            } else return;
        }
    }

    static void print_list(List<Integer> v) {
        for (int i : v) {
            System.out.print(i + ",");
        }
        System.out.println("");
    }

}
