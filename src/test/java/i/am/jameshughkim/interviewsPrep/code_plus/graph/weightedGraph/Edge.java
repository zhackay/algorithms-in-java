package i.am.jameshughkim.interviewsPrep.code_plus.graph.weightedGraph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Edge<T, S> {
    T from;
    T to;
    S weight;

    Edge<T, S> reverse() {
        return new Edge<>(to, from, weight);
    }
}
