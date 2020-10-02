package harper.github.io.linked;

/**
 * 约瑟夫环的问题
 *
 * @Project Main5(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/30 下午12:53
 * @Version 3.0
 */
public class Main5 {

    public Node kill(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = head.next;
        }
        int count = 0 ;
        while (head != last) {

            if (++count == m) {
                // 到数了
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}
