package manacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manacher {

    public static void main(String[] args) {
        System.out.println(maxLcpsLength("abcba"));
    }


    public static char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }

    // 最大回文直径
    public static int maxLcpsLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 加特殊字符生成Manacher所需的字符串
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];   // 回文半径数组
        int C = -1; // 中心
        int R = -1; // 回文右边界再往右一个的位置，最右边界为R-1
        int max = Integer.MIN_VALUE;    //扩的最大值
        for (int i = 0; i != str.length; i++) { //每一个位置求回文半径
            // 至少是多大的回文区域
            // i在R外，回文区域至少是他自己，为1
            // 2 * C - i 为i'的位置
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            // i + pArr[i] 为右回文边界，i - pArr[i]为左回文边界
            while (i + pArr[i] < str.length && i - pArr[i] > 1) {
                // 两种情况会扩
                //  1. R > i
                //  2. R < i， i'的回文左边界刚好等于2 * C - R
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    // 半径+1
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 说明扩成功
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        // max为带#的回文直径，max-1为不带#的回文半径
        return max - 1;
    }
}
