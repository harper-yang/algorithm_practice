package exercise;

// 搜索二叉树转换成双端列表
public class BST2DoubleLinkList {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    // 搜索二叉树转换成双向链表，头和尾返回
    public static class Info {
        public Node start;
        public Node end;

        public Info(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    // 递归套路
    public static Info process(Node x) {
        if (x == null) {
            return new Info(null, null);
        }
        Info leftHeadEnd = process(x.left);
        Info rightHeadEnd = process(x.right);
        if (leftHeadEnd.end != null) {
            // 左边链表连接x节点
            leftHeadEnd.end.right = x;
        }
        x.left = leftHeadEnd.end;
        if (rightHeadEnd.start != null) {
            // 右边链表连接x节点
            rightHeadEnd.start.left = x;
        }
        x.right = rightHeadEnd.start;
        // 返回整个链表的头和尾，leftHeadEnd start为空，则x为头，否则leftHeadEnd.start为头
        return new Info(leftHeadEnd.start == null ? x : leftHeadEnd.start,
                rightHeadEnd.end == null ? x : rightHeadEnd.end);
    }

    public static Node convert(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).start;
    }
}
