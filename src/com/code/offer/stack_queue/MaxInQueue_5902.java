package com.code.offer.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1。
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 */
public class MaxInQueue_5902 {
    /**
     * 使用一个双端队列 deque，在每次入队时，
     * 如果 deque 队尾元素小于即将入队的元素 value，
     * 则将小于 value 的元素全部出队后，再将 value 入队；否则直接入队。
     * 辅助队列 deque 队首元素就是队列的最大值。
     */
    Queue<Integer> que;
    Deque<Integer> deq;

    public MaxInQueue_5902() {
        //队列：插入和删除
        que = new LinkedList<>();
        //双端队列：获取最大值，构造单调队列
        deq = new LinkedList<>();
    }

    public int max_value() {
        //双端队列的队首为que的最大值
        return deq.size() > 0 ? deq.peek() : -1;
    }

    public void push_back(int value) {
        //value入队
        que.offer(value);
        while (deq.size() > 0 && deq.peekLast() < value) {
            //将deq队尾小于value的元素删掉
            deq.pollLast();
        }
        //将value放在deq队尾
        deq.offerLast(value);
    }

    public int pop_front() {
        //获得队首元素
        int tmp = que.size() > 0 ? que.poll() : -1;
        if (deq.size() > 0 && tmp == deq.peek()) {
            //如果出队的元素是当前最大值，将deq的队首出队
            deq.poll();
        }
        return tmp;
    }
}