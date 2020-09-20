package com.code.interview.jd;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 俊语
 * @date 2020/9/17 19:34
 * 201003abc2020输出：2020
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher("1234");
        if (matcher.find()){

        }
        String[] strs = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            if (length >= 4) {
                char ch = str.charAt(length - 2);
                char chLast = str.charAt(length - 1);
                if (ch >= '0' && ch <= '9') {
                    if (!Character.isDigit(chLast)) {
                        str = str.substring(0, length - 1);
                    }
                    if (str.length() == 4) {
                        int temp = Integer.parseInt(str);
                        if (temp >= 1000 && temp <= 3999) {
                            stringBuilder.append(str + " ");
                        }
                    }
                }
            }
        }
        System.out.println(stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()));
    }
}
