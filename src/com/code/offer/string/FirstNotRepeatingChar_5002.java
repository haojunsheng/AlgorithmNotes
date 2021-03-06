package com.code.offer.string;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstNotRepeatingChar_5002 {
    int[] hashTable = new int[256];
    StringBuffer sb = new StringBuffer();

    //Insert one char from string stream
    public void Insert(char ch) {
        sb.append(ch);
        if (hashTable[ch] == 0) {
            hashTable[ch] = 1;
        } else {
            hashTable[ch]++;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] result = sb.toString().toCharArray();
        for (char ch : result) {
            if (hashTable[ch] == 1) {
                return ch;
            }
        }
        return '#';
    }
}