package dp;


import tree.Node;

// 给定一个非负整数，代表二叉树的节点个数，返回能形成多少种不同的二叉树结构
public class UniqueBST {

    public static int process(int n) {
        if (n < 0) {
            return 0;
        }
        // 0是空树，1是一个父节点
        if (n  ==0 || n == 1) {
            return 1;
        }
        // 2是两种结构
        if (n == 2) {
            return 2;
        }

        int res = 0;
        for (int leftNum = 0; leftNum <= n - 1; leftNum++) {
            int leftWays = process(leftNum);
            int rightWays = process(n - 1 - leftNum);
            res += leftWays * rightWays;
        }
        return res;
    }

    public static int dpWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) { // 节点个数为i的时候
            for (int j = 0; j < i; j++) { // 左侧为j个几点
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(process(10));
        System.out.println(dpWays(10));

    }
}

