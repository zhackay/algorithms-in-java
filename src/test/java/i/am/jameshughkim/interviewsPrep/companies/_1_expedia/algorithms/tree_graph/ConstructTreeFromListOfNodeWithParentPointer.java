package i.am.jameshughkim.interviewsPrep.companies._1_expedia.algorithms.tree_graph;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ConstructTreeFromListOfNodeWithParentPointer {

    @Data
    @AllArgsConstructor
    class Node {
        Node parent;
        int id;
    }
}
