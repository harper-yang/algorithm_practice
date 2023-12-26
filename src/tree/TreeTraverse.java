package tree;

import java.util.*;

public class TreeTraverse {

    // 前序：头左右
    // 遍历序中取第一次打印到的值
    // 遍历序列：1，2，4，4，4，2，5，5，5，2，1，3，6，6，6，3，7，7，7，3，1
    // 前序：1，2，4，5，3，6，7
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序：左头右
    // 遍历序中取第二次打印到的值
    // 遍历序列(每个值会回到三次)：1，2，4，4，4，2，5，5，5，2，1，3，6，6，6，3，7，7，7，3，1
    // 中序：4，2，5，1，6，3，7
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    // 后序：左右头
    // 遍历序中取第三次打印到的值
    // 遍历序列(每个值会回到三次)：1，2，4，4，4，2，5，5，5，2，1，3，6，6，6，3，7，7，7，3，1
    // 后序：4，5，2，6，7，3，1
    public static void postOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value);
    }

    // 前序：1，2，4，5，3，6，7
    public static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.value);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    // 中序：4，2，5，1，6，3，7
    public static void inOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || head != null) {
            if (head != null) {
                s.push(head);
                head = head.left;
            } else {
                head = s.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    // 后序：4，5，2，6，7，3，1
    public static void postOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            // s1 是头右左
            head = s1.pop();
            s2.push(head);
            // 因为是栈这里先进左后进右
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().value);
        }
    }

    // 宽度优先遍历：1，2，3，4，5，6，7
    public static void widthRecur(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    // 获得最大宽度
    public static int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int currentNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            // 还在同一层
            if (curNodeLevel == curLevel) {
                currentNodes++;
            } else {
                // 上一层结算,新的一层初始化
                max = Math.max(max, currentNodes);
                curLevel++;
                currentNodes = 1;
            }
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        max = Math.max(max, currentNodes);
        return max;
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
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        // 遍历序列：1，2，4，4，4，2，5，5，5，2，1，3，6，6，6，3，7，7，7，3，1
//        preOrderRecur(head);
//        inOrderRecur(head);
//        preOrderUnRecur(head);
//        postOrderUnRecur(head);
//        inOrderUnRecur(head);
//        widthRecur(head);
        System.out.println(getMaxWidth(head));
    }
}
