package harper.github.io.queueAndStack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的MaxTree
 * MaxTree定义：
 * 1，数组必须没有重复元素
 * 2，MaxTree是一个二叉树，数组的每一个值对应一个二叉树节点
 * 3，包括MaxTree树在内且在其中的而每一棵子树上，值最大的节点都是树的头
 *
 *
 * @Project Main8(harper.github.io.queueAndStack)
 * @Author  yangzhao
 * @Date    2020/9/29 下午7:02
 * @Version 3.0
 */
public class Main8 {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};

        getMaxTree(arr);
    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i != arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            // 找出当前节点的父节点
            if (left == null && right == null) {
                // 说明左右没有比当前节点大的，当前节点为头结点
                head = curNode;
            } else if (left == null) {
                // 说明右边是离当前节点最近的更大节点
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                // 说明左边节点是离当前节点最近的更大节点
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                // 两边节点哪个相对更小，哪个是当前节点的父节点
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }

        }
        return head;
    }

    // 找出每个节点比他大的节点
    public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }
}
