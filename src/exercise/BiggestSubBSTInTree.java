package exercise;

// 获取一棵树的最大搜索子树，返回头节点
public class BiggestSubBSTInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static class Info {
        public Node maxBstHead;
        public boolean isBST;
        public int max;
        public int min;
        public int maxBSTSize;

        public Info(Node head, boolean isBST, int max, int min, int size) {
            this.maxBstHead = head;
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.maxBSTSize = size;
        }
    }

    // 三种情况，要么左子树种存在最大搜索二叉树，要么右子树存在最大搜索二叉树，要么能连起来整棵树都是搜索二叉树
    public static Info process(Node x) {
        if (x == null) {
            return null;
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int min = x.value;
        int max = x.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        boolean IsBST = false;
        int maxBSTSize = 0;
        Node maxBSThead = null;
        if (leftInfo != null) {
            maxBSTSize = leftInfo.maxBSTSize;
            maxBSThead = leftInfo.maxBstHead;
        }
        if (rightInfo != null && rightInfo.maxBSTSize > maxBSTSize) {
            maxBSTSize = rightInfo.maxBSTSize;
            maxBSThead = rightInfo.maxBstHead;
        }

        // 左右都是搜索二叉树
        if ((leftInfo == null || leftInfo.isBST) && (rightInfo == null || rightInfo.isBST)) {
            // 整棵树是搜索二叉树
            if ((leftInfo == null || leftInfo.max < x.value) && (rightInfo == null || rightInfo.min > x.value)) {
                IsBST = true;
                maxBSThead = x;
                maxBSTSize = (leftInfo == null ? 0 : leftInfo.maxBSTSize) + 1 + (rightInfo == null ? 0 : rightInfo.maxBSTSize);
            }
        }

        return new Info(maxBSThead, IsBST, max, min, maxBSTSize);
    }
}
