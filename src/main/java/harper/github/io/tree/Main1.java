package harper.github.io.tree;

/**
 * 用递归方式和非递归方式实现二叉树的先序，中序，后序遍历
 *
 * @Project Main1(harper.github.io.tree)
 * @Author  yangzhao
 * @Date    2020/10/1 下午12:17
 * @Version 3.0
 */
public class Main1 {

    public static void main(String[] args) {
//        Node head = new Node(1);
//        head.left = new Node(2);
//        head.right = new Node(3);
//        head.left.left = new Node(4);
//        head.left.right = new Node(5);
//        head.right.left = new Node(6);
//        head.right.right = new Node(7);
//        head.left.left.left = new Node(8);
//        head.left.left.right = new Node(9);
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.right.right = new Node(6);
        head.left.right.right.right = new Node(7);
        recur(head);
        System.out.println("========");
//        in(head);
//        System.out.println("========");
//        pos(head);
//        System.out.println("========");

    }

    //遍历，用递归的方式
    public static void recur(Node head) {
        if (head == null) {
            return ;
        }
        // 打印行为放这里先序打印 中，左，右
//        System.out.println(head.value);
        recur(head.left);
        // 打印行为放这里中序打印 左，中，右
//        System.out.println(head.value);
        recur(head.right);
        System.out.println(head.value);
        // 打印行为放这里后序打印 左，右，中
    }

    // TODO 用非递归的方式遍历
    public static void recur2(Node head) {

    }
}
