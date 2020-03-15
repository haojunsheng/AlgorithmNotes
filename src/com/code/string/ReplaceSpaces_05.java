package com.code.string;

/**
 * 将字符串中的空格替换为%20
 */

/**
 * 在合并两个数组，包括字符串时，如果从前到后进行处理每个数字，
 * 需要重复移动数字时(有几个空格，需要重复移动多次)，则可以考虑从后向前进行处理，这样可以减少移动的次数，从而提高效率
 */
public class ReplaceSpaces_05 {

    /**
     * 我们先遍历一次字符串，这样就能够统计出字符串中空格的总数，并可以计算出替换之后字符串的总长度。
     * 每替换一个空格，长度增加2，因此替换以后的字符串的长度等于原来的长度加上2乘以空格的数目，
     * 我们还是以前面的字符串”We are happy”为例，“We are happy”这个字符串的长度是14，里面有两个空格，因此替换之后的字符串的长度为18
     * <p>
     * 我们从字符串的后面开始复制和替换。首先准备两个指针，P1和P2，
     * P1指向原始字符串的末尾，而P2指向替换之后的字符串的末尾。
     * 接下来我们向前移动指针P1,逐个把它指向的字符复制到P2指向的位置，直到碰到第一个空格为止。
     * 此时字符串包含如下图b所示，灰色阴影的区域是做了字符拷贝的区域。碰到第一个空格之后，把P1向前移动一格，在P2之前插入字符串”%20“，由于”%20“的长度为3，同时也要把P2向前移动3格如图所示。
     * <p>
     * 我们接着向前复制，直到碰到第二个空格（d)所示。和上一次一样，我们再把P1向前移动1格，并把P2向前移动3格插入”%20“（如图e)，此时P1，P2指向同一个位置，表明所有的空格都已经替换完毕。
     * <p>
     * 从上面的分析我们可以看出，所有的字符都只复制一次，因此这个算法的时间效率是O(n)，比第一个思路要快。
     */

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int len = str.length();
        int count = 0;
        //统计空格的个数
        for (int i = 0; i < len; ++i) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLen = len + count * 2;
        int p1 = len - 1;
        int p2 = newLen - 1;
        // stringBuffer初始化为0
        StringBuffer stringBuffer = new StringBuffer(newLen);
        for (int k = 0; k < newLen; k++) {
            stringBuffer.append('0');
        }
        while (p1 >= 0 && p2 >= p1) {
            // p1遇到空格，p2一次替换为02%
            if (str.charAt(p1) == ' ') {
                stringBuffer.setCharAt(p2--, '0');
                stringBuffer.setCharAt(p2--, '2');
                stringBuffer.setCharAt(p2--, '%');
                // 否则，把p1的值赋值给p2
            } else {
                stringBuffer.setCharAt(p2--, str.charAt(p1));
            }
            p1--;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        char[] olderArray = str.toCharArray();
        // 为简单起见，我们假设给它一个新的空间，空间的大小足以存下替换后的字符
        char[] newArray = new char[100];
        for (int i = 0; i < olderArray.length; i++) {
            newArray[i] = olderArray[i];
        }
        String resultStr = replaceSpace(new StringBuffer(str));
        System.out.println(resultStr);
    }
}