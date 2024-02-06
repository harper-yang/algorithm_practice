package exercise;

// 螺旋打印一个矩阵
public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length;
        int d = matrix[0].length;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--);
        }
    }

    /**
     * 打印边
     * @param m 矩阵
     * @param a 左上角横坐标
     * @param b 左上角纵坐标
     * @param c 右下角横坐标
     * @param d 右下角纵坐标
     */
    public static void printEdge(int[][] m, int a, int b, int c, int d) {
        // 是一条横线
        if (a == c) {
            for(int i = b; i <= d; i++)
                System.out.print(m[a][i] + " ");
        } else if (b == d) {
            // 是一条竖线
            for (int i = a; i <= c; i++) {
                System.out.print(m[i][b] + "");
            }
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) {
                System.out.print(curC);
                curC++;
            }
            while (curR != c) {
                System.out.print(curR);
                curR++;
            }
            while (curC != b) {
                System.out.print(curC);
                curC--;
            }
            while (curR != a) {
                System.out.print(curR);
                curR--;
            }
        }
    }
}
