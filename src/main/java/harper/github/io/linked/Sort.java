package harper.github.io.linked;

/**
 * 排序算法总结
 *
 * @Project Sort(harper.github.io.linked)
 * @Author  yangzhao
 * @Date    2020/9/30 下午2:12
 * @Version 3.0
 */
public class Sort {

    /**
     * - 为了绝对的速度，选择快速排序，为了省空间选择堆排序，为了稳定性选择归并排序。
     * - 不基于比较的排序，对样本数据有严格要求，不易改写。
     * - 基于比较的排序，只要规定好两个样本怎么比大小就可以直接复用
     * - 基于比较的排序，时间复杂度的极限是O(N * logN)
     * - 时间复杂度O(N * logN),额外空间复杂度低于O(N)，且稳定的基于比较的排序是不存在的
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1,2,3,4,5};
//        bubbleSort(arr);
//        selectSort(arr);
//        mergeSort1(arr);
        quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 选择排序 ，选择出最小的放最前面
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // 最小值的索引
            int minIndex = i ;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                swap(arr, i, minIndex);
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] arr) {

        int current = 0 ;
        for (int i = 0; i < arr.length - 1; i++) {
            // 最小值在哪个位置上  i～n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    // 归并排序
    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，变成有序的
    // L...R    N    T(N) = 2*T(N/2) + O(N)  ->
    public static void process(int[] arr, int L, int R) {
        if (L == R) { // base case
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        // help是最终排好序的数组
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            // 分两组，哪个小哪个给help数组，同时index + 1
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    // 快速排序
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        process1(arr, 0, arr.length - 1);
    }


    private static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // 得到基准元素位置
        int M = partition2(arr, L, R);
        //根据基准元素，分为两部分递归
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        // 第一个元素作为基本元素
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    private static int partition2(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while( left != right) {
        //控制right指针比较并左移
            while(left<right && arr[right] > pivot){
                right--;
            }
        //控制right指针比较并右移
            while( left<right && arr[left] <= pivot) {
                left++;
            }
        //交换left和right指向的元素
            if(left<right) {
                swap(arr, left, right);
            }
        }
        //pivot和指针重合点交换
        swap(arr, left, startIndex);
        return left;
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        // 构建一个大根堆
        for (int i = 0; i < arr.length; i++) {
            // 往上升
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        // 将顶与堆尾部交换，此时尾部就是最大值
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            // 重新构建大根堆，只有index = 0 的是需要找到位置的
            // 往下降
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    //i结点的父结点下标就为(i–1)/2。它的左右子结点下标分别为2 * i + 1和2 * i + 2
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            // 当前节点比父节点大，向上移
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //arr[index]位置的数，能否向下移动
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;// 左孩子
        while (left < heapSize) {
            //下方还有孩子
            // 两个孩子中，谁的值大，把下标给largest
            // 1）只有左孩子，left -> largest
            // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
            // 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子的值， right -> largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和较大的孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
