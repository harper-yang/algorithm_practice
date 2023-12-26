package sort;

import java.util.Arrays;

/**
 * 堆结构就是数组实现的完全二叉树结构
 * 先构建大根堆，再将堆顶的值和数组最后一个数交换，重新构建大根堆，依次循环往复。
 * 优先级队列 == 堆结构
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }

        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;

        swap(arr, 0, --heapSize);   // 最后一个数与头节点交换，然后heapSize - 1，相当于在堆上去掉这个数
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    // 向下heapify
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) { // 左孩子没越界
            int large = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;   //判断左右孩子谁大
            large = arr[large] > arr[index] ? large : index;    //判断孩子和父亲谁大
            if (large == index) {
                break;
            }
            swap(arr, large, index);
            index = large;
            left = index * 2 + 1;
        }
    }

    // 变大根堆，某个数处在index位置，向上移动
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 数组中交换i和j位置的数
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, 4, 5, 1, 2 };
        heapSort(arr);
        System.out.println("数组排序 : " + Arrays.toString(arr));
    }
}
