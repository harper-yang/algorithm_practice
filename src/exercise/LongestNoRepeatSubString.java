package exercise;

public class LongestNoRepeatSubString {

    public static int maxUnique(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            // 两个限制条件，pre前一个字符向左推到哪一个位置停的，map[chars[i]] 这个字符上一次出现的位置，max获取的是离我更近的位置
            pre = Math.max(pre, map[chars[i]]);
            // 我推到的距离为i-pre
            cur = i - pre;
            // 更新最大值
            len = Math.max(len, cur);
            map[chars[i]] = i;
        }
        return len;
    }
}
