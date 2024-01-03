package greedyAlgorithm;

public class NQueen {

    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     *
     * @param i 目前来到第i行
     * @param record record[0 ... n-1] 表示之前的行，放了皇后的位置
     * @param n 代表一共多少行
     * @return 返回可以摆放的次数
     */
    public static int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { // 尝试i行所有的列
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);

            }
        }
        return res;
    }

    /**
     * 当前i行的皇后，放到j列，是否合规
     */
    public static boolean isValid(int[] record, int i, int j) {
        // 判断是否共竖线或者共斜线
        for (int k = 0; k < i; k++) {   // record[k] 代表之前record中记录的皇后的位置
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(j - record[i])) {
                return false;
            }
        }
        return true;
    }

    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    // colLimit 列的限制，1 不能放皇后，0可以放皇后
    // leftSlashLimit 左斜线的限制
    // rightSlashLimit 右斜线的限制
    private static int process2(int limit, int colLimit, int leftSlashLimit, int rightSlashLimit) {
        if (colLimit == limit) {
            // 当所有的格子都不能放皇后的，代表终止位置
            return 1;
        }
        // 所有可以放皇后的位置
        int pos = limit & (~(colLimit | leftSlashLimit | rightSlashLimit));

        int mostRightOne = 0;

        int res = 0;
        while (pos != 0) {
            // 找到最右边的1
            mostRightOne = pos & (~pos + 1);
            // 从最右边的1一个一个的放置皇后
            pos = pos - mostRightOne;
            res += process2(limit, (colLimit | mostRightOne),
                    (leftSlashLimit | mostRightOne) << 1,
                    (rightSlashLimit | mostRightOne) >> 1);
        }
        return res;
    }
}
