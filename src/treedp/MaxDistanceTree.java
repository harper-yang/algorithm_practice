package treedp;

/**
 * 获得一棵树两个节点的最远距离。
 */
public class MaxDistanceTree {

    public static int getMaxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        // 获取子树的信息，也要加工出自己的信息 maxDistance, height
        // 分类：节点参与：maxDistance 为左高+右高+1，节点不参与：左maxDistance和右maxDistance的最大值
        int p = leftInfo.height + 1 + rightInfo.height;
        int maxDistance = Math.max(p, Math.max(leftInfo.maxDistance, rightInfo.maxDistance));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, height);
    }
}
