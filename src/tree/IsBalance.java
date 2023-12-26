package tree;

public class IsBalance {

    public static class ReturnType {
        public boolean isBalance;

        public int height;

        public ReturnType(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static boolean isBalance(Node head) {
        return process(head).isBalance;
    }

    private static ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(true, 0);
        }

        ReturnType left = process(node.left);
        ReturnType right = process(node.left);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalance = left.isBalance && right.isBalance && (Math.abs(left.height - right.height) < 2);
        return new ReturnType(isBalance, height);
    }

}
