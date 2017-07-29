package i.am.jameshughkim.interviewsPrep.code_plus.graph.problem_solving;

import i.am.jameshughkim.interviewsPrep.code_plus.graph.simplifiedGraph.Edge;
import i.am.jameshughkim.interviewsPrep.code_plus.graph.simplifiedGraph.Graph;
import i.am.jameshughkim.interviewsPrep.testUtils.Pair;

import java.util.HashMap;
import java.util.List;

public class CountConnectedComponents extends Graph {
    public CountConnectedComponents(List<Pair<Integer, Edge>> edgeList) {
        super(edgeList, false);
    }

    /**
     * Use modified DFS or BFS
     */
    public int countConnectedComponents() {
        this.clearCheckMap();
        int count = 0;

        for (int vertex : check.keySet()) {
            if (check.get(vertex) == false) {
                dfs(vertex);
                count++;
            }
        }

        return count;
    }

}
