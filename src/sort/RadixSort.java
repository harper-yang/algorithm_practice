package sort;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            max = Math.max(max, value);
        }
        int res = 0;
        while (max != 0) {
            max /= 10;
            res++;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digits) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digits; d++) {
            int[] count = new int[radix];   //count[0..9]
            // 10个桶
            // count[0] 当前d位是0的数字有多少个
            // count[1] 当前d位是0 ~ 1的数字有多少个
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            // 处理成累加和
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 从右向左遍历，获取每一个数的d位的值，count[j] 代表数字为j的数在d位上有几个
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }

        }
    }

    // 数x在第d位上为几
    public static int getDigit(int x, int d) {
        return (((x / (int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, 4, 5, 1, 2 };
        // count[j] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 8]
        // 从右向左遍历，count[2] = 2, bucket[1] = 2
        radixSort(arr);
        System.out.println("数组排序 : " + Arrays.toString(arr));
    }
}
