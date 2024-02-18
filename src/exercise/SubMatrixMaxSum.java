package exercise;

// 找到累加和最大的子矩阵
public class SubMatrixMaxSum {

    public static int maxSum(int[][] m) {

        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        /*
         * 处理 1～1 1～2 1～3 1～4
         */
        for (int i = 0; i != m.length; i++) {   // 开始的行号i
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++) {   // 结束的行号j，i～j是我们要讨论的范围
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    // 将i ~ j 行的纵向累加起来
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(cur, max);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }
}
