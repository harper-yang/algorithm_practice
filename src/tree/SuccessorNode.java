package tree;

public class SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node head) {
        if (head == null) {
            return null;
        }
        if (head.right != null) {
            // 有右树，X的后继节点是右数的最左节点
            return getLeftMost(head.right);
        } else {
            // X无右树的情况下，X的后继节点是有左孩子的第一个父节点
            Node parent = head.parent;
            while (parent != null && parent.left != head) {
                head = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
