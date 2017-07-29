package i.am.jameshughkim.interviewsPrep.code_plus.graph.weightedGraph;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class GraphTest {
    /***************
     * TESTS
     ****************/

    static Stream<Triplet<int[], Integer, int[]>> testCases() {
        return Stream.of(
                Triplet.of(new int[]{3,3,3,3},3, new int[] {0, 3}),
                Triplet.of(new int[]{1, 2, 3, 4, 4, 4, 5},4, new int[] {3, 5}),
                Triplet.of(new int[]{3},3, new int[] {0, 0}),
                Triplet.of(new int[]{1, 2, 3, 4, 4, 4, 5},6, new int[] {-1, -1}));
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Triplet<int[], Integer, int[]> testCase) {
        int[] a = testCase.getFirst();
        int k = testCase.getSecond();
        int[] expected = testCase.getThird();

        ArrayList<Edge<Integer, Integer>> edgeList = new ArrayList<>();
        edgeList.add(new Edge<>(1,2,0));
        edgeList.add(new Edge<>(2,3,0));
        edgeList.add(new Edge<>(2,6,0));
        edgeList.add(new Edge<>(2,7,0));
        edgeList.add(new Edge<>(3,8,0));
        edgeList.add(new Edge<>(3,9,0));
        edgeList.add(new Edge<>(3,4,0));
        edgeList.add(new Edge<>(4,5,0));
        edgeList.add(new Edge<>(5,9,0));
        edgeList.add(new Edge<>(5,8,0));
        Graph<Integer, Integer> graph = new Graph(edgeList);
        List<Integer> result = graph.getDfs(1);

        Assertions.assertEquals((List<Integer>)new ArrayList<Integer>(), result);
    }

    @Test
    void addEdge() {
    }

    @Test
    void addEdges() {
    }

    @Test
    void getDfs() {
    }

    @Test
    void getDfsRecursive() {
    }

    @Test
    void getBfs() {
    }

    @Test
    void propagateWeight() {
    }

}