package exercise;

/**
 * 给定一个数组，值的范围是1~n，打印出所有没出现在[1,n]的数
 */
public class PrintNoInArray {

    public static void printNumNoInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int value : arr) {
            // 争取让i位置上，放的数是i+1
            modify(value, arr);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) { //没做到的位置，就是缺了的数字
                System.out.println(i + 1);
            }
        }
    }

    private static void modify(int value, int[] arr) {
        while (value != arr[value - 1]) {
            int tmp = arr[value - 1];
            arr[value - 1] = value;
            value = tmp;
        }
    }
}
