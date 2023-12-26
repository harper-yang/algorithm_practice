package sort;

public class GetMaxValue {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, 4, 5, 1, 2 };
        System.out.println("数组最大值 : " + getMax(arr));
    }
}
