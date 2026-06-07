package com.code.leetcode.map;

import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams_49 {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        // 取个余取个余。
        k = k % nums.length;
        String s;

        // 开辟一个长度为k的子数组出来。
        int[] temp=new int[k];
        int j=0;
        for(int i=nums.length-k;i<nums.length;++i){
            temp[j]=nums[i];
            j++;
        }
        Arrays.stream(temp).forEach(System.out::println);
        System.out.println("------");
        // 处理前半段向后移动。
        for(int i=nums.length-k-1;i>=0;i--){
            nums[i+k]=nums[i];
        }
        Arrays.stream(nums).forEach(System.out::println);        // temp还原到原来
        for(int i=0;i<nums.length-k-1;i++){
            nums[i]=temp[i];
        }
        return;
    }


    public boolean isValid(String s) {
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char ch:chars){
            if(ch=='('||ch =='{'||ch=='['){
                stack.push(ch);
            }else{
                char existCh= stack.pop();

                if(ch!=existCh){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};int k = 2;
        GroupAnagrams_49 groupAnagrams49 = new GroupAnagrams_49();
//        groupAnagrams49.rotate(nums,k);
        System.out.println(groupAnagrams49.isValid("()"));
    }
}