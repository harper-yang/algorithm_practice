package harper.github.io.queueAndStack;

import java.util.LinkedList;

/**
 * 生成窗口最大值的问题
 * 有一个整型的数组和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右滑一个位置
 *
 * @Project Main7(harper.github.io.queueAndStack)
 * @Author  yangzhao
 * @Date    2020/9/29 下午6:16
 * @Version 3.0
 */
public class Main7 {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] maxWindow = getMaxWindow(arr, 3);
        for (int i : maxWindow) {
            System.out.println(i);
        }

    }

    public static int[] getMaxWindow(int[] arr,int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 记录最大值的下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0 ;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                // 放到后面主要是为了滑动
                qmax.pollLast();
            }
            qmax.addLast(i);
            // 判断是否过期
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
