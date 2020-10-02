package harper.github.io.linked;

public class ArrUtils {

    public static Node convertToNode(int[] arr) {
        Node head = null;
        Node cur = null;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            if (head == null) {
                head = node;
            } else {
                cur.next = node;
            }
            cur = node;
        }
        return head;
    }

    public static void printNode(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    /**
     * 链表逆序
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4};
        Node node = convertToNode(arr);
        Node node1 = reverseList(node);

    }

}
