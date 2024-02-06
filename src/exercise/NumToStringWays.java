package exercise;

import javax.print.attribute.standard.NumberUp;

// 将一串数字转成string，1-a，2-b，统计有多少种转换方式
public class NumToStringWays {

    public static int convertWays(int num) {
        if (num < 1) {
            return 0;
        }
        return process(String.valueOf(num).toCharArray(), 0);
    }

    // 0 ... index -1 已经转换完毕
    // str[index] 能转换出多少有效的字符
    private static int process(char[] str, int index) {
        if (index == str.length) {
            // 最后一个字符走完，开始收集
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int res = process(str, index + 1);
        if (index == str.length - 1) { // 除了最后一个字符，没有后续字符了
            return res;
        }
        if (str[index] - '0' * 10 + str[index + 1] - '0' < 27) {
            res += process(str, index + 2);
        }
        return res;
    }

    public static int dpWays(int num) {
        if (num < 1) {
            return 0;
        }
        char[] str = String.valueOf(num).toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        dp[N - 1] = str[N - 1] == '0' ? 0 : 1;
        for (int i = N - 2; i >= 0; i--) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1] + (str[i] - '0' * 10 + str[i + 1] - '0' < 27 ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(convertWays(123));
        System.out.println(dpWays(123));
    }

}
