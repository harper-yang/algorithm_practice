package harper.github.io.linked;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 *
 * @Project Main8(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/30 下午10:22
 * @Version 3.0
 */
public class Main8 {

    public static class Node {
        public int value;
        public Node next;
        public Node random;

        public Node(int value) {
            this.value = value;
        }
    }

    // 使用hashMap 处理
    public Node copyListWithRand(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        // key 原node的value，value复制过的value
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
