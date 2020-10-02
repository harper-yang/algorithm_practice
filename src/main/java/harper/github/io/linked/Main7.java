package harper.github.io.linked;

import java.util.List;

/**
 * 将单项链表按某值划分成左边小，中间相等，右边大的形式
 *
 * @Project Main7(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/30 下午2:03
 * @Version 3.0
 */
public class Main7 {

    public static void main(String[] args) {
        int[] arr = {9, 0, 4, 5, 1};
        Node node = ArrUtils.convertToNode(arr);
        Node node1 = listPartition1(node, 5);
        ArrUtils.printNode(node1);

    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0 ;
        // 循环获取链表的长度
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        // 循环生成一个数组，数组是每一个链表的元素
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        // 快排分治
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];

    }

    public static void arrPartition(Node[] nodeArr, int pivot) {

        int small = -1 ;
        int big = nodeArr.length;
        int index = 0 ;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                // 比基准值小的
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                // 等于基准值的
                index++;
            } else {
                // 比基准值大的
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] arr, int a, int b) {
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
