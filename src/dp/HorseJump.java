package dp;

public class HorseJump {


    // 从(0,0)出发，前往(x,y) 跳step 步
    public static int process(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        if (step == 0) {
            // 跳完了
            return (x == 0 && y == 0) ? 1 : 0;
        }
        // 不越界且还有步数可以跳
        return process(x - 1, y - 2, step - 1) +
                process(x - 2, y - 1, step - 1) +
                process(x + 1, y - 2, step - 1) +
                process(x + 2, y - 1, step - 1) +
                process(x - 1, y + 2, step - 1) +
                process(x - 2, y + 1, step - 1) +
                process(x + 1, y + 2, step - 1) +
                process(x + 2, y + 1, step - 1);
    }

    public static int dpWay(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1;
        for (int h = 1; h <= step; h++) {
            for (int r = 0; r < 9; r++) {
                for (int w = 0; w < 10; w++) {
                    dp[r][w][h] += getValue(dp, r - 1, w - 2, h - 1) +
                            getValue(dp, r - 2, w - 1, h - 1) +
                            getValue(dp, r + 1, w - 2, h - 1) +
                            getValue(dp, r + 2, w - 1, h - 1) +
                            getValue(dp, r - 1, w + 2, h - 1) +
                            getValue(dp, r - 2, w + 1, h - 1) +
                            getValue(dp, r + 1, w + 2, h - 1) +
                            getValue(dp, r + 2, w + 1, h - 1);

                }
            }
        }
        return dp[x][y][step];
    }

    public static int getValue(int[][][] dp, int row, int col, int step) {
        if (row < 0 || row > 8 || col < 0 || col > 9) {
            return 0;
        }
        return dp[row][col][step];
    }

    public static void main(String[] args) {
        System.out.println(dpWay(3, 4, 5));
    }
}
