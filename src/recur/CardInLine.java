package recur;

// 玩家从左或右取一张牌，得到获胜的人的牌加和
public class CardInLine {

    public static int f(int[] arr, int l, int r) {
        // base case
        if (l == r) {
            return arr[l];
        }
        // 左边第一个牌+ 后手其他牌，活着右边第一个牌+后手其他牌
        return Math.max(arr[l] + s(arr, l + 1, r), arr[r] + s(arr, l, r - 1));
    }

    public static int s(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(f(arr, l + 1, r), f(arr, l, r - 1));
    }

    public static int winner(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }
}
