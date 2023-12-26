package sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    // Master公式：T(n) = 2 * T(n/2) + O(n)
    // a = 2, b = 2, c = 1
    // 根据master公式，时间复杂度O(n * logn)
    // 空间复杂度O(n)

    // 如果log(b,a)  < c，复杂度为：O(n^c)
    // 如果log(b,a)  > c，复杂度为：O(n^log(b,a))
    // 如果log(b,a) == c，复杂度为：O(n^c * logn)

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, 4, 5, 1, 2 };
        mergeSort(arr);
        System.out.println("数组排序 : " + Arrays.toString(arr));
    }
}
