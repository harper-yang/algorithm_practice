package hash;

public class BitMap {


    public static void main(String[] args) {


        int[] arr = new int[10];    // 32 bit * 10 -> 320 bit, 1 int = 4byte，1byte = 8bit

        int i = 178; // 想取得178位的bit的状态

        int numIndex = i / 32; // 在arr的哪一个数上
        int bitIndex = i % 32; // 在这个数的哪一位上

        // 获得第i位的状态
        //将这个数移动到最右边，& 1 意思是& 上一个bitIndex位为1，其他位为0的数，将其它位都改成0，只留下了bitIndex位上的数
        int s = ((arr[numIndex] >> bitIndex) & 1);

        // 把i位的状态改成1
        // 1左移bitIndex，只有bitIndex位是1，其他位是0，或上这个1即把i位的状态改成了1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);

        // (~(1 << bitIndex))指bitIndex位上位0，其他位为1
        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));
    }
}
