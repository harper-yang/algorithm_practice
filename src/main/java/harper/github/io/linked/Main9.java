package harper.github.io.linked;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 *
 * @Project Main9(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/30 下午10:29
 * @Version 3.0
 */
public class Main9 {

    public static void main(String[] args) {

    }

    public static Node addList(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        // 链表1放入一个栈中
        while (head1 != null) {
            stack1.push(head1.value);
            head1 = head1.next;
        }
        // 链表2放入一个栈中
        while (head2 != null) {
            stack2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0 ;
        int n1 = 0 ;
        int n2 = 0 ;
        int n = 0 ;
        Node node = null;
        Node pre = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            // 从队尾向前开始组装
            pre = node ;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        // 到第一位时ca=1 加一个节点
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

}
