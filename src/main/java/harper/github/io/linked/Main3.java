package harper.github.io.linked;

/**
 * 删除链表的中间节点和a/b处的节点
 *
 * @Project Main3(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/30 上午10:59
 * @Version 3.0
 */
public class Main3 {

    // 删除中间节点
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        // 中间节点，一次走一步
        Node pre = head;
        // 一次走两步
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        // 找到中间节点
        pre.next = pre.next.next;
        return head;
    }

    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        // 先计算链表的长度
        int n = 0 ;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(a * n / b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
