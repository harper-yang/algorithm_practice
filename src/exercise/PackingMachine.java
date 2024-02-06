package exercise;

public class PackingMachine {

    // arr代表每台洗衣机中的衣服数量，要变成平均值，需要多少轮
    public static int minOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % size != 0) {
            return -1;
        }
        // 获得平均值
        int avg = sum / size;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            // 负 需要输入 正 需要输出
            int leftRest = leftSum - i  * avg;
            // 总数 - 左边总数 - 当前数 = 右边总数
            // 再减去右边需要的总数
            int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return ans;
    }

}
