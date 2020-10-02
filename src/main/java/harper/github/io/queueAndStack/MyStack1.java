package harper.github.io.queueAndStack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 *
 * @Project Test1(harper.github.io.queueAndStack)
 * @Author  yangzhao
 * @Date    2020/9/29 下午12:38
 * @Version 3.0
 */
public class MyStack1 {

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        System.out.println(myStack1.getMin());

    }

    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public void pop(int numNum) {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
    }

    public Integer getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }
}
