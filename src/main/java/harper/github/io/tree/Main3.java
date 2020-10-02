package harper.github.io.tree;

import java.time.temporal.ValueRange;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 *
 * @Project Main3(harper.github.io.tree)
 * @Author  yangzhao
 * @Date    2020/10/1 下午4:30
 * @Version 3.0
 */
public class Main3 {

    // 先序遍历序列化
    public static String serialByPre(Node head) {

        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    // 先序反序列化
    public static Node deserialByPre(String preStr) {
        String[] arr = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.offer(s);
        }
        return deserialByPre(queue);
    }

    private static Node deserialByPre(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.parseInt(s));
        head.left = deserialByPre(queue);
        head.right = deserialByPre(queue);
        return head;
    }


    // 层遍历序列化
    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    public static Node deserialByLevel(String levelStr) {
        String[] arr = levelStr.split("!");
        int index = 0 ;
        Node head = generateNodeByString(arr[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(arr[index++]);
            node.right = generateNodeByString(arr[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    private static Node generateNodeByString(String s) {
        if (s.equals("#")) {
            return null;
        }
        return new Node(Integer.parseInt(s));
    }
}
