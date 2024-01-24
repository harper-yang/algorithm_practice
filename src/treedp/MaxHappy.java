package treedp;

import java.util.List;

/**
 * 获取员工最大快乐值，规定上级来，他的直接下级都不能来。
 */
public class MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;
    }

    public static class Info {
        public int laiMaxHappy;
        public int buLaiMaxHappy;

        public Info(int laiMaxHappy, int buLaiMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buLaiMaxHappy = buLaiMaxHappy;
        }
    }

    public static Info process(Employee x) {
        if (x.nexts.isEmpty()) {    // x是基层员工
            return new Info(x.happy, 0);
        }

        int lai = x.happy;
        int bu = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buLaiMaxHappy;
            bu += Math.max(nextInfo.buLaiMaxHappy, nextInfo.laiMaxHappy);
        }
        return new Info(lai, bu);
    }

    public static int maxHappy(Employee head) {
        Info info = process(head);
        return Math.max(info.buLaiMaxHappy, info.laiMaxHappy);
    }

}
