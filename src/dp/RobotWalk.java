package dp;

// 有N个位置，机器人可以从S的位置，走到E的位置，可以走K步，有多少种走法
public class RobotWalk {

    public static int walkWays(int N, int S, int E, int K) {
        return f(N, E, K, S);
    }

    /**
     * @param N    N个位置
     * @param E    终止位置
     * @param rest 剩余步数
     * @param cur  当前位置
     * @return 返回多少种方法数
     */
    public static int f(int N, int E, int rest, int cur) {
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 0) {
            // 只能向右走
            return f(N, E, rest - 1, cur + 1);
        }
        if (cur == N) {
            // 只能向左走
            return f(N, E, rest - 1, cur - 1);
        }
        return f(N, E, rest - 1, cur - 1) + f(N, E, rest - 1, cur + 1);
    }

    // 记忆化搜索
    public static int walkWays2(int N, int S, int E, int K) {
        int[][] cache = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                cache[i][j] = -1;
            }
        }
        return f2(N, E, K, S, cache);
    }

    public static int f2(int N, int E, int rest, int cur, int[][] cache) {
        if (cache[rest][cur] != -1) {
            return cache[rest][cur];
        }
        if (rest == 0) {
            cache[rest][cur] = cur == E ? 1 : 0;
        } else if (cur == 0) {
            // 只能向右走
            cache[rest][cur] = f(N, E, rest - 1, cur + 1);
        } else if (cur == N) {
            // 只能向左走
            cache[rest][cur] = f(N, E, rest - 1, cur - 1);
        } else {
            cache[rest][cur] = f(N, E, rest - 1, cur - 1) + f(N, E, rest - 1, cur + 1);
        }
        return cache[rest][cur];
    }

    public static int dpWay(int N, int E, int S, int K) {
        int[][] dp = new int[K + 1][N + 1];
        // 第rest为0，当前为E的位置为1
        dp[0][E] = 1;
        // 要获取的是当前位置在S，rest为K的位置
        for (int rest = 1; rest <= K; rest++) {
            for (int cur = 1; cur <= N; cur++) {
                if (cur == 1) {
                    dp[rest][cur] = dp[rest - 1][2];
                } else if (cur == N) {
                    dp[rest][cur] = dp[rest - 1][N - 1];
                } else {
                    dp[rest][cur] = dp[rest - 1][cur + 1] + dp[rest - 1][cur - 1];
                }
            }
        }

        return dp[K][S];
    }
}
