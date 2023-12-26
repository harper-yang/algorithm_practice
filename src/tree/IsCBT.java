package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;
        Node l, r;
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            // 需要是叶子，但是有儿女；有右孩子，没左孩子；都是返回false
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            // 判断儿女不双全，则后续都是叶子节点
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    /*
        1
    2       3
    4   5   6   7
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
//        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        System.out.println(isCBT(head));
    }
}
