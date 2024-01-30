package dp;

// 玩家从左或右取一张牌，得到获胜的人的牌加和
public class CardInLine {

    public static int f(int[] arr, int l, int r) {
        // base case
        if (l == r) {
            return arr[l];
        }
        // 左边第一个牌+ 后手其他牌，或者右边第一个牌+后手其他牌
        return Math.max(arr[l] + s(arr, l + 1, r), arr[r] + s(arr, l, r - 1));
    }

    public static int s(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(f(arr, l + 1, r), f(arr, l, r - 1));
    }

    public static int winner(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int dp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 填充已知的f格子的值
            f[i][i] = arr[i];
        }
        int row = 0;
        int col = 1;
        while (col < arr.length) {
            int i = row;
            int j = col;
            while (i < arr.length && j < arr.length) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
                i++;
                j++;
            }
            col++;
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }
}
