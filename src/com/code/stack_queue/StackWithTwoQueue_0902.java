package com.code.stack_queue;


import java.util.LinkedList;

public class StackWithTwoQueue_0902 {
    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;

    public void push(int num) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.push(num);
            // queue1非空，压入queue1
        } else if (!queue1.isEmpty()) {
            queue1.push(num);
        } else {
            queue2.push(num);
        }
    }

    public Integer pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return null;
        }
        int value = 0;
        // queue1中有值，除了最后一个全部移动到q2,然后q2弹出即可
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.push(queue1.pop());
            }
            value = queue1.pop();
        } else {
            // 同上
            while (queue2.size() > 1) {
                queue1.push(queue2.pop());
            }
            value = queue2.pop();
        }
        return value;
    }

    public static void main(String[] args) {

    }
}

