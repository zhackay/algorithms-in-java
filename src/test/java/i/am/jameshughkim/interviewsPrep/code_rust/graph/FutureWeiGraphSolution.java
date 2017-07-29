package i.am.jameshughkim.interviewsPrep.code_rust.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FutureWeiGraphSolution {
    public FutureWeiGraphSolution() {

    }

    class Edge {
        String id;
        Integer weight;

        public Edge(String id) {
            this.id = id;
        }

        public Edge(String id, int weight) {
            this(id);
            this.weight = weight;
        }
    }

    class Node {
        String id;
        List<String> dependsOn;

        public Node(List<String> dependsOn) {
            this.dependsOn = dependsOn;
        }
    }

    class Graph {
        HashMap<String, List<Edge>> ajDependsOnList; // vertex depends on the list
        HashMap<String, List<Edge>> ajDependentOfList; // vertex is dependent of the list

        public Graph(Node[] vertices) {
            for(int i=0;i<vertices.length; i++) {
                String vertexId = vertices[i].id;
                List<String> dependsOn = vertices[i].dependsOn;
                for(String edgeId : dependsOn) {
                    this.addDependency(vertexId, new Edge(edgeId));
                }
            }
        }

        public void addDependency(String vertexId, Edge edge) {
            addEdgeToDependsOnList(vertexId, edge);
            addEdgeToDependentOfList(vertexId, edge);
        }

        public void assign(String vertexId, int val) {
//            ajDependsOnList.get(vertexId)
        }

        private void addEdgeToDependsOnList(String vertexId, Edge edge) {
            // add edge to dependsOn list
            if (!this.ajDependsOnList.containsKey(vertexId)) {
                List<Edge> dependsOnTos = new ArrayList<>();
                this.ajDependsOnList.put(vertexId, dependsOnTos);
            }
            else { // decided to not to handle, but, can make change to overwrite
                System.out.println("duplicate vertex (" + vertexId + ") detected");
                return;
            }
            List<Edge> edges = this.ajDependsOnList.get(vertexId);
            edges.add(edge);
            this.ajDependsOnList.put(vertexId, edges);
        }

        private void addEdgeToDependentOfList(String vertexId, Edge edge) {
            // add edge to dependentOf list
            if (!this.ajDependentOfList.containsKey(edge.id)) {
                List<Edge> dependentOf = new ArrayList<>();
                this.ajDependentOfList.put(edge.id, dependentOf);
            }
            List<Edge> edges = this.ajDependentOfList.get(edge.id);
            edges.add(new Edge(vertexId));
            this.ajDependentOfList.put(edge.id, edges);
        }
    }

}
