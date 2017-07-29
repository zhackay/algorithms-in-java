package i.am.jameshughkim.interviewsPrep.code_plus.graph.problem_solving;

import java.util.HashMap;

public class PermutationCycle {
    private HashMap<Integer, Boolean> check = new HashMap<>();
    private int[] a;

    public PermutationCycle(int[] a) {
        this.a = a;
    }

    /**
     * Very similar to countConnectedComponents, but, don't need to use adjacency list, at all.
     *
     */
    public int countPermutationCycle() {
        int count = 0;
        for (int i=0;i<a.length;i++) {
            if (!check.getOrDefault(i, false)) {
                dfs(i); // go through all the unvisited elements
                count++;
            }
        }
        return count;
    }

    private void dfs(int x) {
        if (check.getOrDefault(x, false)) return;
        check.put(x, true);

        // edge를 다 검사할 필요없이 다음 정점을 찾으면 됨 (다음 정점은 하나뿐임 = a[x])

        dfs(a[x]); // get to x position
    }

    /**
     * 어떤 하나의 함수가 그 하나의 함수를 부르는 형태의 재귀함수는 쉽게 비재귀로 바꿀수 있음
     *
     */
    private void dfsIterative(int x) {
        while (check.getOrDefault(x, false)) {
            check.put(x, true);

            x = a[x]; // 위의 dfs함수와 비교!
        }
    }



}
