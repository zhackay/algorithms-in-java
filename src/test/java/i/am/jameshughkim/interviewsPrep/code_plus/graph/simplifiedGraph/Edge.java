package i.am.jameshughkim.interviewsPrep.code_plus.graph.simplifiedGraph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Edge {
    int vertex; // to
    int weight;

    public Edge(int vertex) {
        this(vertex, 0);
    }
}
