package com.code.offer.stack_queue;


import java.util.Queue;

public class StackWithTwoQueue_0902 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public void push(int num) {
        if (!queue2.isEmpty()) {
            queue2.offer(num);
        } else {
            queue1.offer(num);
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
                queue2.offer(queue1.poll());
            }
            value = queue1.poll();
        } else {
            // 同上
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            value = queue2.poll();
        }
        return value;
    }

    public static void main(String[] args) {

    }
}

