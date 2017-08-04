package cheat.graph.simplifiedGraph;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import lombok.Data;

import java.util.*;

@Data
public class Graph {
    protected HashMap<Integer, ArrayList<Edge>> adjList;
    protected HashMap<Integer, Boolean> check;

    public Graph(List<Pair<Integer, Edge>> edgeList, boolean directed) {
        adjList = new HashMap<>();
        check = new HashMap<>();

        for (Pair<Integer, Edge> pair : edgeList) {
            int vertex = pair.getFirst();
            Edge edge = pair.getSecond();

            addEdge(vertex, edge);
            if (!directed) addReversedEdge(vertex, edge);
        }
    }

    public void addEdge(int vertex, Edge edge) {
        ArrayList<Edge> neighbors = adjList.get(vertex);
        neighbors.add(edge);

        adjList.put(vertex, neighbors);
    }

    public void addReversedEdge(int vertex, Edge edge) {
        ArrayList<Edge> neighbors = adjList.get(edge.vertex);
        neighbors.add(new Edge(vertex, edge.weight));

        adjList.put(vertex, neighbors);
    }

    public void dfs(int curVertex) {
        clearCheckMap();
        dfsRecursive(curVertex);
    }

    public void clearCheckMap() {
        check.clear();

        for (int vertex : adjList.keySet()) {
            check.put(vertex, false);
        }
    }

    private void dfsRecursive(int curVertex) {
        // 1. if already visited, return
        if (check.get(curVertex) == true) return;

        // 2. if not visited, set to true
        check.put(curVertex, true);

        // 3. do stuff

        // 4. For each edges, if not visited, do dfs for that vertex
        for (Edge edge : adjList.get(curVertex)) {
            int vertex = edge.getVertex();
            if (check.get(vertex) == false)
                dfsRecursive(vertex);
        }
    }

    public void bfs(int start) {
        clearCheckMap();

        Queue<Integer> q = new LinkedList<>();

        // 1. add the root to the queue and mark it as visited
        q.add(start);
        check.put(start, true);

        // 2. while q is not empty
        while (!q.isEmpty()) {

            // 4. Pop the queue
            int curVertex = q.remove();

            // 5. do stuff

            // 6. For each edges, if not visited, add the root to the queue and mark it as visited
            for (Edge edge : adjList.get(curVertex)) {
                int vertex = edge.getVertex();
                if (!check.get(vertex)) {
                    check.put(vertex, true);
                    q.add(vertex);
                }
            }
        }
    }
}
