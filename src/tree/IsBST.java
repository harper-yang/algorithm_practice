package tree;

public class IsBST {

    static int preValue = Integer.MIN_VALUE;

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBST = isBST(head.left);
        if (!isLeftBST || head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return isBST(head.right);
    }

    public static void main(String[] args) {
        /*
            1
        2       3
        4   5   6   7
         */
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        System.out.println(isBST(head));

        /*
            5
         3      7
         1  4   6   8
         */
        // preValue全局变量，只能一次一次调用
        Node head2 = new Node(5);
        head2.left = new Node(3);
        head2.right = new Node(7);
        head2.left.left = new Node(1);
        head2.left.right = new Node(4);
        head2.right.left = new Node(6);
        head2.right.right = new Node(8);
        System.out.println(isBST(head2));
    }
}
