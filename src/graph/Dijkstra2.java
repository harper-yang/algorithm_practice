package graph;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra2 {

    // 从head出发，所有head能到达的节点，记录head到该节点的最短距离
    public static Map<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        Map<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }

    public static class NodeHeap {
        // 小根堆底层是数组
        private Node[] nodes;
        // 用于记录Node在小根堆中的位置
        private Map<Node, Integer> heapIndexMap;
        // 记录Node到head节点的distance
        private Map<Node, Integer> distanceMap;
        private int size;

        public NodeHeap(Integer size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // node有没有进来过
        public boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        // 是否在堆上, 约定进来了又被弹出的node的index是-1
        public boolean isHeaped(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        // 交换堆上的两个node，包括heapIndex
        public void swap(Integer index1, Integer index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }

        // 变小根堆，某个数处在index位置，向上移动
        public void insertHeapify(int index) {
            // node节点与父亲节点比较
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        // 向下heapify
        public void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) { // 左孩子没越界
                int smallest = left + 1 < heapSize && distanceMap.get(nodes[left]) < distanceMap.get(nodes[left + 1]) ? left : left + 1;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            // 如果节点已经在堆上, 则比较现在的最短距离和堆上已有的最短距离
            if (isHeaped(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(heapIndexMap.get(node));
            }
            // 从来没有进过
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord record = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            // 将size - 1的值设置为-1
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            heapify(0, --size);
            return record;
        }
    }

    public static class NodeRecord {

        public Node node;
        public Integer distance;

        public NodeRecord(Node node, Integer distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
