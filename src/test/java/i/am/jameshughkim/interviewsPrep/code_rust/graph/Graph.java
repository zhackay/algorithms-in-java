package i.am.jameshughkim.interviewsPrep.code_rust.graph;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    HashMap<Integer, ArrayList<Edge>> a = new HashMap<>();

    public Graph(int v) {
        for (int i=0; i<v; i++)
            a.put(i, new ArrayList<>());
    }

    public void setEdge(Edge e) {
        ArrayList<Edge> edges = a.get(e.from);
        edges.add(e);
        a.put(e.from, edges);
    }

    public Edge getEdge(int from, int to) {
        ArrayList<Edge> edges = a.get(from);
        for (Edge e: edges) {
            if (e.to == to) return e;
        }
        return null;
    }

    public void dfs(int x) {
        boolean[] check = new boolean[x];
        recursiveDfs(x, check);
    }

    public void recursiveDfs(int x, boolean[] check) {
        check[x] = true;

        /* 다음 정점 찾기
            - 정점에 연결된 모든 간선의 첫번째 노드가 a[x]임
            - 그러므로 정점의 모든 간선의 수는 a[x].size임
         */
        for (int i=1; i<=a.get(x).size(); i++) {
            Edge y = a.get(x).get(i); // x -> i의 간선. 간선의 존재 여부를 검사할 필요는 없음 (인접 행렬은 없는 간선도 저장하지만, 인접 리스트는 있는 간선만 저장하므로)
            if (check[y.to] == false) // i를 방문 안했으면
                recursiveDfs(y.to, check);
        }

    }

    public Edge bfs() {
        throw new NotImplementedException();
    }
}
