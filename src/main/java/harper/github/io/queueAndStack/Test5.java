package harper.github.io.queueAndStack;

import java.util.Stack;

/**
 * 一个栈中的元素为整型，要将该栈从顶到底按从大到小的顺序排序，只允许申请一个栈。
 *
 * @Project Test5(harper.github.io.queueAndStack)
 * @Author  yangzhao
 * @Date    2020/9/29 下午6:04
 * @Version 3.0
 */
public class Test5 {

    /**
     * 对栈中数据进行排序，
     * @param stack 要排序的栈
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            while (help.isEmpty() && help.peek() > current) {
                // 如果stack 当前元素大于help的栈顶元素（栈顶是最小的）
                stack.push(help.pop());
            }
            help.push(current);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
