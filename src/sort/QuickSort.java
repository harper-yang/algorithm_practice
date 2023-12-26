package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);

    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int)(Math.random() * (R -L +1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[0] + 1, R);
        }
    }

    // 默认以arr[r]做划分 arr[r] -> p    <p    ==p    >p
    // 最右边的数为r起始值
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;   //左边界
        int more = R;   //右边界
        while (L < more) {  // L表示当前数的位置
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }   //划分三个界限
        swap(arr, more, R); //将目标值插入到划分好的中间的位置
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, 4, 5, 1, 2 };
        quickSort(arr);
        System.out.println("数组排序 : " + Arrays.toString(arr));
    }
}
