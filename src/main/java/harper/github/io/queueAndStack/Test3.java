package harper.github.io.queueAndStack;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 * 一个栈一次压入1，2，3，4，5，那么从栈顶到栈底分别是5，4，3，2，1。将这个栈转置后，从栈顶到栈底为1，2，3，4，5，也就是实现栈中元素的逆序，但是只能用递归函数来实现。
 *
 * @Project Test(harper.github.io.queueAndStack)
 * @Author  yangzhao
 * @Date    2020/9/29 下午5:21
 * @Version 3.0
 */
public class Test3 {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // 将栈中的栈底元素返回并移除
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return ;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
