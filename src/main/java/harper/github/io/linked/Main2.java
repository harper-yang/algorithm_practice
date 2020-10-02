package harper.github.io.linked;

/**
 * 在单链表和双链表中删除倒数第K个节点
 *
 * @Project Main2(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/29 下午11:31
 * @Version 3.0
 */
public class Main2 {

    // 移除单链表的倒数第K个节点
    public static Node removeLastKthNode(Node head, int lastKth) {

        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;

        // 重头遍历一遍
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        // 说明第k个节点刚好是头结点
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = head.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }

        // 双向链表移除倒数第K个节点，注意链表的指针重连
        public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
            if (head == null || lastKth < 1) {
                return head;
            }
            DoubleNode cur = head;
            while (cur != null) {
                lastKth --;
                cur = head.next;
            }
            if (lastKth == 0) {
                head = head.next;
                head.last = null;
            }
            if (lastKth < 0) {
                cur = head;
                while (++lastKth != 0) {
                    cur = cur.next;
                }
                DoubleNode newNext = cur.next.next;
                cur.next = newNext;
                if (newNext != null) {
                    newNext.last = cur;
                }
            }
            return head;

        }
    }
}
