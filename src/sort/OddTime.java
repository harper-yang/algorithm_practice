package sort;

public class OddTime {

    public static void printOddTimeNum(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        // eor = a ^ b
        // eor != 0, eor 必有一位为1
        int rightOne = (~eor + 1) & eor;

        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));

    }

    public static void main(String[] args) {
        printOddTimeNum(new int[]{1, 1, 2, 2, 3, 4, 4, 5,});
    }
}
