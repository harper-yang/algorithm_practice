package graph;

public class GraphGenerator {

    /*
    matrix 结构
    [from,to,value]
    [from,to,value]
    [from,to,value]
    [from,to,value]...
     */
    public static Graph generateGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int[] arr : matrix) {
            int from = arr[0];
            int to = arr[0];
            int weight = arr[0];
            // 放入点集
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.out++;
            fromNode.nexts.add(toNode);
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}
