package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortDistanceLessK {

    public static void sortDistanceLessK(Integer[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++) {
            heap.add(arr[index]);
            arr[i++] = heap.poll();
        }

        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 8, 7, 6, 4, 5, 1, 2 };
        sortDistanceLessK(arr, 6);
        System.out.println("数组排序 : " + Arrays.toString(arr));
    }
}
