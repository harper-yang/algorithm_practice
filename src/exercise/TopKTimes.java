package exercise;

import java.util.HashMap;

/**
 * 持续的给字符串，获取词频最高的K个string
 */
public class TopKTimes {

    public static class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public static class TopKRecord {
        // 词频表
        private final HashMap<String, Node> strNodeMap;
        // 小跟堆
        private final Node[] heap;
        // Node在堆上的位置
        private final HashMap<Node, Integer> nodeIndexMap;
        // 目前为止堆有多少元素
        private int heapSize;

        public TopKRecord(int K) {
            heap = new Node[K];
            heapSize = 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }

        public void add(String str) {
            Node curNode = null;
            int preIndex = -1;
            // 不在词频上
            if (!strNodeMap.containsKey(str)) {
                // 新建出节点
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                // 不在堆上就标记为-1
                nodeIndexMap.put(curNode, -1);
            } else {
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            // 不在堆上
            if (preIndex == -1) {
                // 堆满了
                if (heapSize == heap.length) {
                    // 门槛没有新来的节点的次数大
                    if (heap[0].times < curNode.times) {
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, heapSize);
                    }
                } else  {
                    // 堆没满，挂到index节点
                    nodeIndexMap.put(curNode, heapSize);
                    heap[heapSize] = curNode;
                    heapInsert(heapSize++);
                }
            } else {
                // 在堆上，单纯的数字+1，调整小根堆
                heapify(preIndex, heapSize);
            }
        }


        // 向下heapify
        public void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) { // 左孩子没越界
                int smallest = left + 1 < heapSize && heap[left].times < heap[left + 1].times ? left : left + 1;
                smallest = heap[smallest].times < heap[index].times ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        // 变小根堆，某个数处在index位置，向上移动
        public void heapInsert(int index) {
            // node节点与父亲节点比较
            while (heap[index].times < heap[(index - 1) / 2].times) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        // 交换堆上的两个node，包括heapIndex
        public void swap(Integer index1, Integer index2) {
            nodeIndexMap.put(heap[index1], index2);
            nodeIndexMap.put(heap[index2], index1);
            Node tmp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = tmp;
        }
    }
}
