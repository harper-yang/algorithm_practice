package harper.github.io.linked;

/**
 * 反转部分单项链表
 * 给定一个单项链表的头结点head，以及两个整数head，to，在单项链表上把第from个节点到第to个节点这一部分进行翻转
 * 1->2->3->4->5->null from = 2, to =4
 * result
 * 1->4->3->2->5->null
 *
 * @Project Main4(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/30 上午11:29
 * @Version 3.0
 */
public class Main4 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node node = ArrUtils.convertToNode(arr);
        Node node1 = revertPart(node, 2, 4);
        System.out.println(node1);

    }

    public static Node revertPart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        // 要反转部分的后一个节点
        Node fPre = null;
        // 要反转部分的后一个节点
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        // 先判断1 <= from <=to <=N ,如果不满足，则直接返回原来的头结点
        if (from > to || from < 1 || to > len) {
            return head;
        }
        // node1 = 2345
        node1 = fPre == null ? head : fPre.next;
        // node2 = 3
        Node node2 = node1.next;
        // 这步是2 -> 5
        node1.next = tPos;
        Node next = null;
        // 循环完node2变成4325
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;

    }
}
