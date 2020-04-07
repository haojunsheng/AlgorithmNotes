

# 递归

## 24-两两交换链表中的节点

迭代解法：

<img src="img/image-20200405225339258.png" alt="image-20200405225339258" style="zoom:33%;" />

```java
public ListNode swapPairsCycle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        while (point.next != null && point.next.next != null) {
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }
```

递归：

```java
public ListNode swapPairsRecursive(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairsRecursive(head.next.next);
        n.next = head;
        return n;
    }
```

## 779- 第K个语法符号

```java
/**
 * 第K个语法符号
 * 在第一行我们写上一个0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * 输入: N = 1, K = 1
 * 输出: 0
 * 输入: N = 2, K = 1
 * 输出: 0
 * 输入: N = 2, K = 2
 * 输出: 1
 * 输入: N = 4, K = 5
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * <p>
 * <p>
 * 注意:
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 */
public class kthGrammar_779 {
    /**
     * 可以看出，如果K小于等于所在行的一半，也就是2^N-2，那么直接去上一行找，也就是下面的helper(N-1, K, flag);
     * 反之，要从后半部分找，而后半部分，正是01翻转后的前一行，也就是helper(N-1, K - half, 1-flag)。
     * 这里 flag 是0或1，来回翻转。
     *
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
        return kthGrammarHelper(N, K, 0);
    }
    private int kthGrammarHelper(int N, int K, int flag) {
        if (N == 1) {
            return flag;
        }
        int half = (1 << (N - 2));
        if (K <= half) {
            return kthGrammarHelper(N - 1, K, flag);
        } else {
            return kthGrammarHelper(N - 1, K - half, 1 - flag);
        }
    }
}
```



# 数组

## 498-对角线遍历

给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

**示例:**

```
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

解释:
```

<img src="img/image-20200406180340115.png" alt="image-20200406180340115" style="zoom:33%;" />

**说明:**

1. 给定矩阵中的元素总数不会超过 100000 。



找规律：

每一趟对角线中元素的坐标（x, y）相加的和是递增的。
第一趟：1 的坐标(0, 0)。x + y == 0。
第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x + y == 1。
第三趟：7 的坐标(0, 2), 5 的坐标(1, 1)，3 的坐标(2, 0)。第三趟 x + y == 2。
第四趟：……

每一趟都是 x 或 y 其中一个从大到小（每次-1），另一个从小到大（每次+1）。
第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x 每次-1，y 每次+1。
第三趟：7 的坐标(0, 2), 5 的坐标(1, 1)，3 的坐标(2, 0)。x 每次 +1，y 每次 -1。

确定初始值。例如这一趟是 x 从大到小， x 尽量取最大，当初始值超过 x 的上限时，不足的部分加到 y 上面。
第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x + y == 1，x 初始值取 1，y 取 0。
第四趟：6 的坐标(2, 1)，8 的坐标(1, 2)。x + y == 3，x 初始值取 2，剩下的加到 y上，y 取 1。

确定结束值。例如这一趟是 x 从大到小，这一趟结束的判断是， x 减到 0 或者 y 加到上限。
第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x 减到 0 为止。
第四趟：6 的坐标(2, 1)，8 的坐标(1, 2)。x 虽然才减到 1，但是 y 已经加到上限了。

这一趟是 x 从大到小，那么下一趟是 y 从大到小，循环进行。 并且方向相反时，逻辑处理是一样的，除了x，y和他们各自的上限值是相反的。
x 从大到小，第二趟：2 的坐标(1, 0)，4 的坐标(0, 1)。x + y == 1，x 初始值取 1，y 取 0。结束值 x 减到 0 为止。
x 从小到大，第三趟：7 的坐标(0, 2)，5 的坐标(1, 1)，3 的坐标(2, 0)。x + y == 2，y 初始值取 2，x 取 0。结束值 y 减到 0 为止。

```java
/**
 * 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class FindDiagonalOrder_498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[]{};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        // 索引，遍历多少趟
        int index = 0, nums = 0;
        while (nums < rows + cols - 1) {
            // 奇数趟
            int x1 = (nums < rows) ? nums : (rows - 1);
            int y1 = nums - x1;
            while (x1 >= 0 && y1 < cols) {
                result[index++] = matrix[x1][y1];
                x1--;
                y1++;
            }
            nums++;
            if (nums >= rows + cols - 1) break;
            // 偶数趟
            int y2 = (nums < cols) ? nums : (cols - 1);
            int x2 = nums - y2;
            while (y2 >= 0 && x2 < rows) {
                result[index++] = matrix[x2][y2];
                x2++;
                y2--;
            }
            nums++;
        }
        return result;
    }
}
```

