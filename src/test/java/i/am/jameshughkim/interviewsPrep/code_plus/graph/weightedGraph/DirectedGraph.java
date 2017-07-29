package i.am.jameshughkim.interviewsPrep.code_plus.graph.weightedGraph;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class DirectedGraph<T, S> {
    HashSet<T> vertices;
    HashMap<T, List<Edge<T, S>>> adjList;

    public DirectedGraph(List<Edge<T, S>> edges) {
        this.adjList = new HashMap<>();
        this.vertices = new HashSet<>();

        this.addEdges(edges);
    }

    public void addEdge(Edge<T, S> edge) {
        T id = edge.getFrom();
        this.vertices.add(id);
        List<Edge<T, S>> edgeList = this.adjList.get(id);
        if (null == edgeList) {
            edgeList = new ArrayList<>();
        }
        edgeList.add(edge);
        this.adjList.put(id, edgeList);
    }

    public void addEdges(List<Edge<T, S>> edges) {
        for (Edge<T, S> edge : edges) {
            addEdge(edge);
        }
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
            List<Edge<T, S>> edgeList = this.adjList.get(vertexId);
            for (Edge<T, S> edge : edgeList) {
                T newVertexId = edge.to;
                if (!visited.contains(newVertexId)) {
                    result.add(newVertexId);
                    visited.add(newVertexId);
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

        for (Edge<T, S> neighborEdge : adjList.get(startingId)) {
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

            for (Edge<T, S> neighborEdge : adjList.get(vertex)) {
                T neighborVertex = neighborEdge.to;
                if (!visited.contains(neighborVertex)) {
                    visited.add(neighborVertex);
                    q.add(neighborVertex);
                }
            }
        }
        return result;
    }

    public S propagateWeight(S val) {
        throw new NotImplementedException();
    }




}
