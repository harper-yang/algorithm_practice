package harper.github.io.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的按层打印与zigZag打印
 *
 * @Project Main5(harper.github.io.tree)
 * @Author  yangzhao
 * @Date    2020/10/2 下午12:15
 * @Version 3.0
 */
public class Main5 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        printByLevel(head);
    }

    public static void printByLevel(Node head) {
        if (head == null) {
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        int level = 1 ;
        // 当前行最右节点
        Node last = head;
        // 下一行最右节点
        Node nLast = null;
        queue.offer(head);
        System.out.print(" level " + (level++) + ": ");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            // head == last 说明当前行走到最右了，要换行了
            if (head == last && !queue.isEmpty()) {
                System.out.print("\n level " + (level++) + ": ");
                last = nLast;
            }
        }
        System.out.println();
    }
}
