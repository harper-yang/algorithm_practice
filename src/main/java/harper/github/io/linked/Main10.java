package harper.github.io.linked;

import java.util.HashSet;

/**
 * 删除无序单链表中值重复出现的节点
 *
 * @Project Main10(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/10/1 上午10:57
 * @Version 3.0
 */
public class Main10 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
        Node node = ArrUtils.convertToNode(arr);
        removeRep2(node);
        ArrUtils.printNode(node);
    }

    public static void removeRep1(Node head) {
        if (head == null) {
            return ;
        }
        HashSet<Integer> set = new HashSet<>();
        // pre 是head中的一部分
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public static void removeRep2(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            //
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

}
