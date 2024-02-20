package exercise;

// 获取一个完全二叉树的节点个数
public class CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    private static int bs(Node node, int level, int h) {
        if (level == h) {
            // level 已到达最大深度
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {
            // node右子节点的高度等于h，说明node的左子树是满二叉树
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            // node右节点的左子树高度不等于h，说明node的左子树不是满二叉树，node的右子树为满二叉树，但是这个满二叉树的高度要减1
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }

    }

    /**
     * 获取node节点的最左最大深度
     * @param node 当前节点
     * @param level node 在level层
     * @return 以node为头的子树，最大深度是多少
     */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

}
