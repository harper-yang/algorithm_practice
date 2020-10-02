package harper.github.io.tree;

/**
 * 打印二叉树的边界节点
 *
 * @Project Main2(harper.github.io.tree)
 * @Author  yangzhao
 * @Date    2020/10/1 下午3:13
 * @Version 3.0
 */
public class Main2 {

    public static void printEdge1(Node head) {
        if (head == null) {
            return ;
        }
        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印左边界
        for (int i = 0; i != edgeMap.length; i++) {
            System.out.println(edgeMap[i][0].value + "");
        }
        // 打印既不是左边界，也不是右边界的叶子节点
        printLeafNotInMap(head, 0, edgeMap);
        for (int i = edgeMap.length - 1; i != -1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.println(edgeMap[i][1].value + "");
            }
        }
    }

    private static void printLeafNotInMap(Node h, int l, Node[][] m) {
        if (h == null) {
            return ;
        }
        if (h.left == null && h.right == null && h != m[l][0] && h != m[l][1]) {
            System.out.println(h.value + "");
        }
        printLeafNotInMap(h.left, l + 1, m);
        printLeafNotInMap(h.right, l + 1, m);
    }

    private static void setEdgeMap(Node h, int l, Node[][] edgeMap) {
        if (h == null) {
            return;
        }
        edgeMap[1][0] = edgeMap[1][0] == null ? h : edgeMap[1][0];
        edgeMap[1][1] = h;
        setEdgeMap(h.left, l + 1, edgeMap);
        setEdgeMap(h.right, l + 1, edgeMap);
    }

    private static int getHeight(Node h, int l) {
        if (h == null) {
            return l;
        }
        return Math.max(getHeight(h.left, l + 1), getHeight(h.right, l + 1));
    }
}
