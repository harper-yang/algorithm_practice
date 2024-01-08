package kmp;

public class KMP {

    // S length > m length
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.isEmpty() || s.length() < m.length()) {
            return -1;
        }
        //
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        // 过程为根据前缀，i1往后推，i2往前跳
        // str1 比较的起始索引
        int i1 = 0;
        // str2 比较的起始索引
        int i2 = 0;

        int[] nextArr = getNextArray(str2); // 获得str2的前缀数组，字符的前n个字符和后n个字符相等，该字符在数组中的位置值记录为n

        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if(i2 == 0) {    // 代表i2的前缀已经用完，i1只能从下一个字符从头开始比较
                i1++;
            } else {
                // 跳到最大前缀后一个开始继续比较
                i2 = nextArr[i2];
            }
        }
        // i2越界代表匹配到了，i1越界代表无法匹配
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] arr) {


    }
}
