package harper.github.io.queueAndStack;

import java.util.Stack;

/**
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add，poll，peek）
 *
 * @Project Test2(harper.github.io.queueAndStack)
 * @Author  yangzhao
 * @Date    2020/9/29 下午4:58
 * @Version 3.0
 */
public class TwoStackQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.poll();
        System.out.println(queue);
    }

    public TwoStackQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(Integer num) {
        stackPush.push(num);
    }

    public Integer poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.isEmpty()) {
            // 从push 的stack全部倒出来到pop的stack
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else if (stackPop.isEmpty()) {
            // 从push 的stack全部倒出来到pop的stack
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
