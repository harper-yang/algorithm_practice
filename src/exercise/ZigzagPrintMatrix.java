package exercise;

// 要求按照斜的S型打印
public class ZigzagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean from = true;
        while (a != endR + 1) {
            printLevel(matrix, a, b, c, d, from);
            // 第一个点如果向右没有到头，则向右走，到头了，向下走
            // 第二个点如果向下没有到头，则向下走，到头了，向左走
            a = a == endC ? a + 1 : a;
            b = b == endC ? b : b + 1;
            d = d == endR ? d + 1 : d;
            c = c == endR ? c : c + 1;
        }
    }


    /**
     * @param m 矩阵数组
     * @param a 第一个点的横坐标
     * @param b 第一个点的纵坐标
     * @param c 第二个点的横坐标
     * @param d 第二个点的纵坐标
     * @param f true: 右上往左下打印，false：左下往右上打印
     */
    public static void printLevel(int[][] m, int a, int b, int c, int d, boolean f) {
        // 每次动一个
        if (f) {
            while (a != c + 1) {
                System.out.print(m[b++][c--] + " ");
            }
        } else {
            while (d != b + 1) {
                System.out.print(m[c--][d++] + " ");
            }
        }
    }
}
