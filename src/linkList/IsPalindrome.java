package linkList;

import java.util.Stack;

public class IsPalindrome {

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    // need n extra space.
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 快慢指针
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        // 1 2 3 4 4 3 2 1
        // right = 2 3 4 4
        // cur = 1 3 4 2
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;    // 为了让快指针到达最后， 慢指针到达重点的next位置
        }

        // stack目的是为了获取后面的 4，3，2，1
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {   //寻找中点
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 开始逆序后半部分的链表
        n2 = n1.next; //后半部分的首个节点
        n1.next = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;   // n3保存下一个节点
            n2.next = n1;   // n2的下一个节点倒转   关键转换 保证n2的next是原链中的上一个节点（n1）
            n1 = n2;        // n1 移动到下一个节点
            n2 = n3;        // n2 移动到下一个节点
        }
        n3 = n1; // n3保存最后一个节点
        n2 = head;  // n2重置为头节点

        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        // 有半部分逆序回来
        n1 = n3.next;
        n3.next = null; // n3是头，先把n3的next换成null，再把n3变成上一个节点的next（n1）  => n1.next = n3
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        System.out.println(isPalindrome3(head));
    }
}
