package harper.github.io.tree;

import java.util.HashMap;

/**
 * 找到二叉树的最大搜索二叉子树
 * 搜索二叉树：左子节点的所有数都小于该节点，右子节点的所有数都小于该节点
 * @Project Main4(harper.github.io.tree)
 * @Author  yangzhao
 * @Date    2020/10/2 上午11:57
 * @Version 3.0
 */
public class Main4 {

    public static Node biggestSubBST(Node head) {
        int[] record = new int[3];
        return posOrder(head, record);
    }

    // 后序遍历
    private static Node posOrder(Node head, int[] record) {

        if (head == null) {
            record[0] = 0 ;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.value;
        Node left = head.left;
        Node right = head.right;
        Node lBST = posOrder(left, record);
        // 节点数
        int lSize = record[0];
        // 左子树最小值
        int lMin = record[1];
        int lMax = record[2];
        Node rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(rMax, value);
        if (left == lBST && right == rBST && lMax < value && value < rMin) {

            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }
}
