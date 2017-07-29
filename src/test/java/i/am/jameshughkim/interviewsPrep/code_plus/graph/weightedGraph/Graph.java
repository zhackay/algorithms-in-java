package i.am.jameshughkim.interviewsPrep.code_plus.graph.weightedGraph;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class Graph<T, W> {
    HashSet<T> vertices = new HashSet<>();
    HashMap<T, List<Edge<T, W>>> adjList = new HashMap<>();

    public Graph(List<Edge<T, W>> edges) {
        for (Edge<T, W> edge: edges) {
            this.addEdge(edge);
            this.addEdge(edge.reverse());
        }
    }

    public void addEdge(Edge<T, W> edge) {
        T id = edge.getFrom();
        this.vertices.add(id);

        List<Edge<T, W>> neighbors = adjList.get(id);
        if (null == neighbors) {
            neighbors = new ArrayList<>();
        }
        neighbors.add(edge);
        adjList.put(id, neighbors);
    }

    // return list of vertex in dfs order
    public List<T> getDfs(T startingId) {
        if (!vertices.contains(startingId)) return null;

        Stack<T> s = new Stack<>();
        List<T> result = new ArrayList<>();
        HashSet<T> visited = new HashSet<>();

        s.push(startingId);

        while (!s.empty()) {
            T vertexId = s.pop();

            // process and mark visited
            result.add(vertexId);
            visited.add(vertexId);

            // add neighbors to the stack
            List<Edge<T, W>> edgeList = this.adjList.get(vertexId);

            for (Edge<T, W> edge : edgeList) {
                T newVertexId = edge.to;
                if (!visited.contains(newVertexId)) {
                    s.push(newVertexId);
                }
            }

        }
        return result;
    }

    public List<T> getDfsRecursive(T startingId) {
        HashSet<T> visited = new HashSet<>();
        List<T> result = new ArrayList<>();

        dfsRecursive(startingId, visited, result);

        return result;
    }

    private void dfsRecursive(T startingId, HashSet<T> visited, List<T> result) {
        if (visited.contains(startingId)) return;
        visited.add(startingId);
        result.add(startingId);

        for (Edge<T, W> neighborEdge : adjList.get(startingId)) {
            T neighborVertex = neighborEdge.getTo();
            if (!visited.contains(neighborVertex))
                dfsRecursive(neighborVertex, visited, result);
        }
    }

    // return list of vertex in dfs order
    public List<T> getBfs(T startingId) {
        if (!vertices.contains(startingId)) return null;
        Queue<T> q = new ArrayDeque<>();
        List<T> result = new ArrayList<>();
        HashSet<T> visited = new HashSet<>();

        q.add(startingId);
        visited.add(startingId);

        while(!q.isEmpty()) {
            T vertex = q.remove();
            result.add(vertex);

            for (Edge<T, W> neighborEdge : adjList.get(vertex)) {
                T neighborVertex = neighborEdge.to;
                if (!visited.contains(neighborVertex)) {
                    visited.add(neighborVertex);
                    q.add(neighborVertex);
                }
            }
        }
        return result;
    }

    public W propagateWeight(W val) {




        throw new NotImplementedException();
    }

    public Graph clone(Graph<T, W> graph) {
        throw new NotImplementedException();

    }

    /**
     * Use DFS or BFS
     * @param startingNode
     * @return
     */
    public int countConnectedComponents(T startingNode) {
        throw new NotImplementedException();
    }

    /**
     * Bipartite Graph is defined as having two set of vertices A, and B
     *  where vertices in A aren't connected each other and
     *  and vertices in B aren't connected each other
     *  But, there exists at least one edge connecting from A to B for each vertex
     *
     *  Use DFS or BFS
     * @return
     */
    public boolean isBipartiteGraph() {
        throw new NotImplementedException();
    }


}
