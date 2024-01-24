package linkList;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 存储下标， 大 到 小
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {  //窗口的R
            // 弹出直到 i位置上的值比队列尾部的值小
            while (!qMax.isEmpty() && arr[qMax.pollLast()] <= arr[i]) {
                qMax.pollLast();
            }
            // 将i添加到尾部
            qMax.addLast(i);
            // 如果最大值为L的下标，则弹出
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            if (i >= w - 1) {
                // 左边存的最大值
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaxWindow(new int[]{1, 2, 3, 4, 6}, 3)));
        System.out.println(Arrays.toString(getMaxWindow(new int[]{5, 4, 3, 2, 1}, 3)));
    }
}
