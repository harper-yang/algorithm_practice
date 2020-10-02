package harper.github.io.tree;

import java.util.Stack;

/**
 * 调整搜索二叉树中的两个错误的节点
 *
 * @Project Main6(harper.github.io.tree)
 * @Author  yangzhao
 * @Date    2020/10/2 下午12:33
 * @Version 3.0
 */
public class Main6 {


    // 如果对所有节点不一样的搜索二叉树进行中序遍历，那么节点值会一直升序，如果有两个节点位置错了，一定是出现了降序
    public static Node[] getTwoErrNodes(Node head) {
        Node[] arr = new Node[2];
        if (head == null) {
            return arr;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while (!stack.isEmpty() || head == null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                //
                if (pre != null && pre.value > head.value) {
                    arr[0] = arr[0] == null ? pre : arr[0];
                    arr[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return arr;
    }
}
