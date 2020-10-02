package harper.github.io.linked;

/**
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 *
 * @Project Main1(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/29 下午8:22
 * @Version 3.0
 */
public class Main1 {

    // 是有序链表，谁小谁往后挪
    public void printCommonSort(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + "");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
