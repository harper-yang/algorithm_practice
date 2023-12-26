package tree;

public class LowerCommonAncestor {

    public static Node lowerCommonAncestor(Node head, Node p, Node q) {
        if (head == null || head == p || head == q) {
            // 遇到空，或者p，或者q，直接返回head
            return head;
        }
        Node l = lowerCommonAncestor(head.left, p, q);
        Node r = lowerCommonAncestor(head.right, p, q);
        if (l != null && r != null) {
            // 左树也搜到，右树也搜到，说明到了公共节点了
            return head;
        }
        if (l == null && r == null) {
            // 都没搜到返回空
            return null;
        }
        // l和r一个为空，一个不为空
        // 返回不空的那个
        return l != null ? l : r;
    }
}
