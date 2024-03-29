package graph;

import java.util.*;

public class TopologySort {

    public static List<Node> sortTopology(Graph graph) {
        // key node
        // value: 剩余入度
        Map<Node, Integer> inMap = new HashMap<>();
        // 入度为0的队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        // 初始化inMap
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

}
