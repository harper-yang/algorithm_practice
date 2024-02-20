package exercise;

// 给定字符串 eg: 0&1|0^1，返回desired（true/false），有多少种结合方式
public class ExpressionNumber {

    public static boolean isValid(char[] exp) {
        if ((exp.length & 1) == 0) {
            // 判断长度是否是奇数
            return false;
        }
        for (int i = 0; i < exp.length; i = i + 2) {
            if ((exp[i] != 1) && (exp[i] != 0)) {
                // 奇数位必须是0 或 1
                return false;
            }
        }
        for (int i = 1; i < exp.length; i = i + 2) {
            if (exp[i] != '&' && exp[i] != '^' && exp[i] != '|') {
                return false;
            }
        }
        return true;
    }

    public static int num(String express, boolean desired) {
        if (express == null || express.isEmpty()) {
            return 0;
        }

        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return p(exp, desired, 0, exp.length - 1);
    }

    // exp[L, R] 返回期待是desired的方法数
    // L，R不要压中逻辑符号
    private static int p(char[] exp, boolean desired, int L, int R) {
        if (L == R) {
            if (exp[L] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }

        int res = 0;
        if (desired) {
            // L + 1 为第一个逻辑符号，确保逻辑符号两边的值和符号计算过后与desire相等
            for (int i = L + 1; i < R; i = i + 2) {
                switch (exp[i]) {
                    case '&' -> {
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                    }
                    case '|' -> {
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                    }
                    case '^' -> {
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                    }
                }
            }
        } else {    // 期待为false
            // L + 1 为第一个逻辑符号，确保逻辑符号两边的值和符号计算过后与desire相等
            for (int i = L + 1; i < R; i = i + 2) {
                switch (exp[i]) {
                    case '&' -> {
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                    }
                    case '|' -> {
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                    }
                    case '^' -> {
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                    }
                }
            }
        }
        return res;
    }
}
