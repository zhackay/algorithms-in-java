package cheat.graph;

import i.am.jameshughkim.interviewsPrep.code_plus.graph.simplifiedGraph.Edge;
import i.am.jameshughkim.interviewsPrep.code_plus.graph.simplifiedGraph.Graph;
import i.am.jameshughkim.interviewsPrep.testUtils.Pair;

import java.util.HashMap;
import java.util.List;

public class IsBiGraph extends Graph {

    private HashMap<Integer, Integer> colorMap;

    public IsBiGraph(List<Pair<Integer, Edge>> edgeList) {
        super(edgeList, false);

    }

    /**
     *
     */
    public boolean isBigraph(int start) {
        clearColorMap();

        for (int vertex: this.adjList.keySet()) {
            if (colorMap.get(vertex) == 0 && !isBigraph(vertex, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean isBigraph(int curVertex, int color) {
        colorMap.put(curVertex, color);
        for (Edge edge : adjList.get(curVertex)) {
            int vertex = edge.getVertex();
            if (colorMap.get(vertex) == 0) {
                if (!isBigraph(vertex, 3 - color))
                    return false;
            } else if (colorMap.get(vertex) == colorMap.get(curVertex))
                return false;
        }
        return true;
    }

    private void clearColorMap() {
        colorMap.clear();

        for (int vertex: adjList.keySet()){
            colorMap.put(vertex, 0);
        }
    }

}
