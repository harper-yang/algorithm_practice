package greedyAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public static class Node {
        public int profit;
        public int cost;

        public Node(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return node1.cost - node2.cost;
        }
    }

    public static class MaxProfitsComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return node2.profit - node1.profit;
        }
    }

    /**
     *
     * @param k k次选择项目
     * @param w 初始资金
     * @param profits 利润数组
     * @param costs 花费数组
     * @return 总利润
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] costs) {
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>(new MaxProfitsComparator());
        // 将所有项目放进花费的小根堆中
        for (int i = 0; i < profits.length; i++) {
            minCostQueue.add(new Node(profits[i], costs[i]));
        }
        for (int i = 0; i < k; i++) {
            // 能够得着的项目，全部解锁
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost < w) {
                maxProfitQueue.add(minCostQueue.peek());
            }
            if (maxProfitQueue.isEmpty()) {
                return w;
            }
            // 加上这轮项目的利润
            w += maxProfitQueue.poll().profit;
        }
        return w;
    }
}
