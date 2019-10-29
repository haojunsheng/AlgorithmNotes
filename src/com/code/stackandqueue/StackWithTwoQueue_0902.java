package com.code.stackandqueue;


import java.util.LinkedList;
import java.util.Stack;

public class StackWithTwoQueue_0902 {
    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;

    public void push(int num){
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.push(num);
        }else if(!queue1.isEmpty()){
            queue1.push(num);
        }else {
            queue2.push(num);
        }
    }
    public Integer pop(){
        if (queue1.isEmpty()&&queue2.isEmpty())
            return null;
        int value=0;
        if(!queue1.isEmpty()){
            while (queue1.size()>1){
                queue2.push(queue1.pop());
            }
            value=queue1.pop();
        }else {
            while (queue2.size()>1){
                queue1.push(queue2.pop());
            }
            value=queue2.pop();
        }
        return value;
    }

    public static void main(String[] args){

    }

}

