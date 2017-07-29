package i.am.jameshughkim.interviewsPrep.code_plus.graph.weightedGraph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vertex<T, S> {
    T id;
    List<Edge<T, S>> neighbors;
}
