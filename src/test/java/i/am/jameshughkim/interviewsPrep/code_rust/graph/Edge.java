package i.am.jameshughkim.interviewsPrep.code_rust.graph;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    int weight;
    int from;
    int to;
}
