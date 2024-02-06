package exercise;

public class BracketLength {

    // 判断最长的括号子串
    public static int maxLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];

        int pre = 0;
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            // 只考虑右括号，左括号都为0
            if (chars[i] == ')') {
                // 与chars[i] 配对的左括号的索引
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxLength("()(())"));
    }
}
