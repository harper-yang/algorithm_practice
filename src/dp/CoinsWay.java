package dp;

// 给定一个数组，每一个数代表一种货币，没有重复值，aim为加起来的钱
public class CoinsWay {

    public static int way1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    /**
     *
     * @param arr 面值arr
     * @param index 可以自由使用arr[index..]之后的面值
     * @param rest 需要搞定的剩余钱数是rest
     * @return 方法数
     */
    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            ways += process(arr, index + 1, rest - arr[index] * zhang);
        }
        return ways;
    }

    public static int way2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
                    ways += dp[index + 1][rest - arr[index] * zhang];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public static int way3(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        System.out.println(way1(new int[]{10, 5,2}, 10));
        System.out.println(way2(new int[]{10, 5,2}, 10));
        System.out.println(way3(new int[]{10, 5,2}, 10));
    }
}
