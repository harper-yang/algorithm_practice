package recur;

// 汉诺塔问题
public class Hanoi {


    // 流程
    // 1.将 i - 1 从start 挪到other
    // 2. 将i 从start挪到end
    // 3. 将i - 1 从other挪到start
    public static void process(int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            process(i - 1, start, other, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            process(i - 1, other, start, end);
        }
    }

    public static void hanoi(int i) {
        if (i > 0) {
            process(i, "左", "右", "中");
        }
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
