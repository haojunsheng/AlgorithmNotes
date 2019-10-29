package com.code.recursive;

// 题目描述 https://www.nowcoder.com/practice/50959b5325c94079a391538c04267e15
//在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
// 请编写一个函数，使用递归的方法生成N位的格雷码。
//给定一个整数n，请返回n位的格雷码，顺序为从0开始。


//方法一：递归
//递归的思路就是n位gray码是由n-1位gray码生成，举个例子简单一些：
//比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
//那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
//添加1后需要顺序反向就变成(110,111,101,100)
//组合在一起就是(000,001,011,010,110,111,101,100)

public class GrayCode {
    public  static String[] getGray(int n) {
        if(n == 1)
            return new String[]{"0","1"};
        String[] lastRes=getGray(n-1);
        String[] res=new String[lastRes.length * 2];
        for(int i=0;i<lastRes.length;i++){
            res[i]="0"+lastRes[i];
            res[i+lastRes.length]="1"+lastRes[lastRes.length-1-i];
        }
        return res;
    }

    public static void main(String args[]){
        GrayCode.getGray(3);
    }
}