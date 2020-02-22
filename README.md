<!--ts-->

<!--te-->

# 1.概述

https://www.cxyxiaowu.com/7072.html

思考为什么他可以写出这么好的代码，把每道题的思路理解后用笔记本记录下来，争取刷到融会贯通，即看见有个题能自动归类到某个方面，这样有一定好处。面试最重要的是让面试官日后能愿意与你以后一起工作，因此沟通交流非常重要。比如有时候面试需要交流，看着像是一道排序的题做不出来，就可以跟面试官交流：“我有几个不成熟的想法，一排序，二动态规划，三是直接搜索算法”，面试官可能就给个提示：“你先用排序试试吧“。

**各种时间复杂度和空间复杂度**
 [complexity.md](complexity.md) 

**常用的数据结构：**
数组，链表，二叉树，栈和队列。

**常用的算法：大多数是基于查找和排序。**
递归的核心思想是如果要求f(n),那么我只需要知道f(n-1)即可。循环的核心思想是要求f(n),我可以从f(1)一直求到f(n)。

我们应该重点掌握**二分查找，归并排序和快速排序**。这三种必须可以手撕代码。
如果面试题要求在排序的数组或者部分排序的数组中查找一个数字或者统计某数字出现的次数，可以尝试使用二分查找算法。

在查找中，哈希表和二叉排序树的考察重点在数据结构上，而不是算法上。哈希表的时间复杂度为O(1)，原理是空间换时间，题目代表50“第一个只出现一次的字符”，可以关注布隆过滤器的实现。

在排序中，需要掌握各种排序算法的平均时间复杂度，最差时间复杂度，空间复杂度，另快排是十分重要的。
快排的核心是随机选择一个数字，比这个数字大的移动到左边，比这个数字小的移动到右边。可以用递归和循环来实现。


当题目要求在二维数组上（迷宫或者棋盘）上搜索路径，我们可以尝试使用回溯法，很适合采用递归的手段来实现。
如果明确指出不可以使用递归的话，可以使用栈来模拟递归。

回溯法是升级版的暴力法，从解决问题的每一步的所有可能选项选出一项，然后进入下一步，进行重复选择，直到最终状态。（在到达递归边界前的某层，由于一些事实不需要向任何一个子问题进行递归，直接返回上一层，这种做法称为回溯法）。

动态规划和贪心算法。
动态规划用于求某个问题的最优解(通常是最大值和最小值)，并且该问题可以分解为多个子问题。
需要符合两个特点：1.求最优解，即求最值。2.整体的最优解依赖于各个子问题的最优解。3.子问题之间有相互重叠的更小的子问题。4.根据第三点，子问题之间有重叠，所以从上向下分析问题，从下向上求解问题。

位运算：与，或，异或，左移和右移。
需要关注的是右移，分为有符号和无符号两种，如果是无符号，则直接用0填补左边的n位，如果是有符号的负数，如10001010 >> 3= 11110001
把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0。也是很多二进制问题的解决思路。

自上而下的分析问题，自下而上的解决问题。


**数据结构类题目**

# 2.数组
这种题目的关键在于找出规律
[数组中重复的数字(3)](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/DuplicationInArray_0301.java)
【核心】核心是数字i出现在下标为i的位置上

[二维数组中的查找(4)](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/FindInPartiallySortedMatrix_04.java)
本题的规律在于矩阵右上角和左下角比较特殊，比该行所有元素大，比该列所有元素小。而左上角没有这样的规律。


[旋转数组旋转数组的最小数字（11）](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/sortAndFind/MinNumberInRotatedArray_11.java)
本题还属于二分查找算法。


[调整数组顺序使奇数位于偶数前面(21)](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/ReorderArray_21.java)
双指针法，一般就是找规律和空间换时间。

[数组中出现次数超过一半的数字(39)](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/OverHalfInArray_39.java)

[最小的k个数（40）](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/highQuality/KLeastNumbers_40.java)
**partition，即分治算法，十分的重要。可以用在快排算法中，还可以用来实现在长度为n的数组中查找第k大的数字**比如，面试题39，数组中出现次数超过一半的数字和面试题40，最小的k个数。其中，**我们有成熟的算法的时间复杂度为O(n)得到数组中任意第k大的数字，假设你选择的数字p在快排一轮完成后下标是m，那么比p小的数字就有m个，如果k小于m，那么第k大的数字一定在p的左边，否则在右边。**

--- 这里----
[连续子数组的最大和42](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/GreatestSumOfSubarrays_42.java)

[把数组排成最小的数45](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/SortArrayForMinNumber_45.java)
考察了大数问题，以及自定义排序规则

[数字在排序数组中出现的次数53](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/NumberOfK_5301.java)
**看见有序，肯定就是二分查找了。** 二分查找十分的重要。

[数组中只出现一次的数字56](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/NumbersAppearOnce_5601.java)
这个类型的题目还是比较有意思的，可以借助于位运算优化时间复杂度和空间复杂度，用来解决其他数字出N（N>=2）次，而一个数字出现1次都可以用这种解法来推导出这个出现1次的数字。

需要注意的是，数组中只出现一次的两个数字，其他的数字都出现了两次。这个题目要把数组分成两部分来解决。

[构建乘积数组66](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/ConstuctArray_66.java)


# 3 链表

简单题目：
递归和栈的知识。

[从尾到头打印链表6](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/PrintListInReversedOrder_06.java)
思路：
  从尾到头打印列表
  第一种方法是把链表就地反转，但是这样会修改原来的链表，一般不这样做
  第二种：顺序遍历，逆序打印，发现和栈的结构是一样的，所以可以使用栈来实现
  第三种：栈的本质就是递归，所以也可以使用递归来实现。

[面试题18：删除链表中的节点](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/DeleteNodeInList_18.java)
思路：把下一个节点的值保存到该节点，然后删除下一个节点即可，需要考虑只有一个节点和删除尾节点的特殊情况。

[面试题：删除链表中的重复节点](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/deleteDuplication.java)
思路：保存要比较节点的前一个节点，需要注意：重复节点的位置（头部，中间和尾部）。


[面试题22：链表中倒数第k个节点](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/KthNodeFromEnd_22.java)

当在链表中一个指针不能解决问题的时候，可以尝试使用两个指针来遍历，其中一个指针的速度快点，另外一个指针的速度慢点，或者一个先走，另一个后走。
详见面试题22。

举一反三：求链表的中间节点。我们的思路是：一个指针每次走两步，另一个走一步，快的走到末尾的时候，慢的恰好在中间。


[面试题24：反转链表](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/ReverseList_24.java)
循环和递归两种方法都要会。

[面试题25：合并两个排序链表](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/MergeList_25.java)
循环和递归两种方法都要会。


[面试题52：两个链表的第一个公共节点](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/FirstCommonNodesInLists_52.java)
可以暴力去解，需要时间复杂度为O(mn)
还可以使用栈的特性，思路是倒着找，因为如果有相同的，最后一个肯定是相同的。
最好的思路是一个指针先走，另一个指针后走。

[面试题62：圆圈中最后剩余的数字](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/LastRemaining_62.java)

本质上是约瑟夫环问题,解决思路：
 1. 用环形链表去模拟
 2. 找出相应的数学规律
     f[1]=0;
     f[i]=(f[i-1]+m)%i;  (i>1)


[面试题35：复杂链表的复制](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/CopyList_35.java)
考察把复杂问题分解的能力，用到了空间换时间的思想，能够在O(1)的时间复杂度找到下一个随机节点。

[面试题36：二叉搜索树与双向链表](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/BinaryTreeConvert_36.java)
双向链表


# 4. 二叉树&递归

二叉查找树（也叫二叉搜索树，BST），平衡二叉树（AVL树），并查集，堆，哈夫曼树。

**二叉树的深度优先遍历**

[重建二叉树7](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/ConstructBinaryTree_07.java)
用到了递归的知识。


[面试题8:二叉树的下一个节点](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/NextNodeInBinaryTrees_08.java)
需要进行归纳总结出相应的规律。

[面试题26：树的子结构](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/IsSubTree_26.java)

[面试题27：二叉树的镜像](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/MirrorTree_27.java)

[面试题28：对称的二叉树](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/SymmetricalBinaryTree_28.java)


[面试题33：二叉搜索树的后序遍历](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/SquenceOfBST_33.java)

[面试题34：二叉树中和为某值的路径](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/PathInTree_34.java)


[面试题55：二叉树的深度,平衡二叉树](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/TreeDepth_5501.java)
在遍历二叉树的时候，优化的算法一般是每个节点尽量只遍历一次，不要进行重复遍历，而且在遍历的时候，要及时进行剪枝，如果结果已经出现，要及时的进行返回。

宽度优先遍历：
[面试题32：从上向下打印二叉树,分行，不分行，按之字形顺序打印二叉树](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/ConstructBinaryTree_07.java)

二叉树的特例：二叉搜索树。搜索时间复杂度logn

[面试题36：二叉搜索树与双向链表](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/BinaryTreeConvert_36.java)


[面试题68：树中两个节点的最低公共祖先](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/ConstructBinaryTree_07.java)

二叉树的特例：堆分为最大堆和最小堆。

二叉树的特例：红黑树

**看到这里**
[面试题40：最小的k个数](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/KLeastNumbers_40.java)。

[面试题54：二叉搜索树的第k大节点](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/tree/KthNodeInBST_54.java)


# 5. 栈和队列
顺序是牛客网
005-用两个栈实现队列
020-包含min函数的栈
021-栈的压入、弹出序列
044-翻转单词顺序列(栈)
064-滑动窗口的最大值(双端队列)

[使用两个栈实现队列9](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/stack/QueueWithTwoStacks_09.java)

[包含min函数的栈30](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/stack/CustomStack_30.java)

[栈的压入、弹出序列31](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/stack/StackSequence_31.java)


Heap（牛客网顺序）
029-最小的K个数
Hash Table
034-第一个只出现一次的字符
图
065-矩阵中的路径(BFS)
066-机器人的运动范围(DFS)


# 6. 字符串
[替换空格5](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/ReplaceSpaces_05.java)



[正则表达式匹配19](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/RegularMatch_19.java)

[表示数值的字符串20](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/NumericStrings_20.java)

[字符串的排列38](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/StringPermutation_38.java)

[第一个只出现一次的字符50](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/FirstNotRepeatingChar_50.java)

[左旋转字符串58](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/LeftRotateString_5802.java)

[翻转单词顺序序列46 ，58](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/ReverseWordsInSentence_58.java)

[把字符串转换成整数67](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/StringToInt_67.java)


**算法类**

**斐波那契数列（牛客网顺序）**

[斐波拉契数列10](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/sortAndFind/Fibonacci_10.java)
008-跳台阶，本质上属于斐波那契数列。
009-变态跳台阶
010-矩形覆盖

**搜索算法**
001-二维数组查找
[二维数组中的查找(4)](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/FindInPartiallySortedMatrix_04.java)
本题的规律在于矩阵右上角和左下角比较特殊，比该行所有元素大，比该列所有元素小。而左上角没有这样的规律。

006-旋转数组的最小数字（二分查找）
[旋转数组旋转数组的最小数字（11）](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/sortAndFind/MinNumberInRotatedArray_11.java)

037-数字在排序数组中出现的次数（二分查找）
[数字在排序数组中出现的次数53](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/array/NumberOfK_5301.java)
**看见有序，肯定就是二分查找了。** 二分查找十分的重要。

**全排列**
027-字符串的排列
[字符串的排列38](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/string/StringPermutation_38.java)

位运算
011-二进制中1的个数
012-数值的整数次方
040-数组中只出现一次的数字
其他算法
002-替换空格
013-调整数组顺序使奇数位于偶数前面
028-数组中出现次数超过一半的数字
031-整数中1出现的次数（从1到n整数中1出现的次数）
032-把数组排成最小的数
033-丑数
041-和为S的连续正数序列(滑动窗口思想)
042-和为S的两个数字(双指针思想)
043-左旋转字符串(矩阵翻转)
046-孩子们的游戏-圆圈中最后剩下的数(约瑟夫环)
051-构建乘积数组


# 6. 递归和循环
递归的关键是递归边界和递归式。

下面几个本质上属于斐波那契数列：
[斐波拉契数列10](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/sortAndFind/Fibonacci_10.java)
跳台阶
变态跳台阶（这个不是斐波那契）
矩形覆盖

数值的整数次方16


# 7. 查找和排序

**如果面试题要求在排序的数组或者部分排序的数组中查找一个数字或者统计某数字出现的次数，可以尝试使用二分查找算法。**

查找常用的有：二分查找，顺序查找，二叉排序树查找和哈希表查找。

在查找中，哈希表和二叉排序树的考察重点在数据结构上，而不是算法上。哈希表的时间复杂度为O(1)，原理是空间换时间，题目代表50“第一个只出现一次的字符”，可以关注布隆过滤器的实现。

在排序中，需要掌握各种排序算法的平均时间复杂度，最差时间复杂度，空间复杂度，另快排是十分重要的。
快排的核心是随机选择一个数字，比这个数字大的移动到左边，比这个数字小的移动到右边。可以用递归和循环来实现。

**partition，即分治算法，十分的重要。可以用在快排算法中，还可以用来实现在长度为n的数组中查找第k大的数字**比如，面试题39，数组中出现次数超过一半的数字和面试题40，最小的k个数。其中，**我们有成熟的算法的时间复杂度为O(n)得到数组中任意第k大的数字，假设你选择的数字p在快排一轮完成后下标是m，那么比p小的数字就有m个，如果k小于m，那么第k大的数字一定在p的左边，否则在右边。**

```java
public void quickSort(int A[],int left,int right){
        //非法输入
        if(A==null||A.length==0||left<0||right>A.length-1||left>=right)
            return;
        int pos=partition(A,left,right);
        quickSort(A,left,pos-1);
        quickSort(A,pos+1,right);
    }

public int partition(int A[],int left,int right){
  int temp=A[left];
  while (left<right){//只要两个数不相遇
    while (left<right&&A[right]>=temp)//从右边找小于temp的值
      right--;
    A[left]=A[right];//找到则交换
    while (left<right&&A[left]<=temp)//从左边找大于temp的值
      left++;
    A[right]=A[left];
  }
  A[left]=temp;
  return left;
}
```

排序
035-数组中的逆序对(归并排序)
029-最小的K个数(堆排序)
029-最小的K个数(快速排序)


# 8. 动态规划和贪心算法

动态规划用于求某个问题的最优解(通常是最大值和最小值)，并且该问题可以分解为多个子问题。
需要符合几个特点：1.求最优解，即求最值。2.整体的最优解依赖于各个子问题的最优解。3.子问题之间有相互重叠的更小的子问题。4.根据第三点，子问题之间有重叠，所以从上向下分析问题，从下向上求解问题。

[剪绳子14](https://github.com/haojunsheng/JavaLearning/blob/master/CodingInterview/src/com/code/dpAndGreedy/CuttingRope_14.java)
动态规划：
1、定义函数f(n)表示为把长度为n的绳子剪成若干段后各段长度乘积的最大值。
2、对于第一刀，我们有n-1种可能的选择，可推导出f(n)=max{f(i)* f(n-i)};
3、很明显这是一个从上至下的递归，但是这个递归存在很多重复的计算，所以使用至下而上的动态规划，将子问题的最优解保存。
4、注意绳子剪成ix(n-i)和(n-i)xi是相同的；
5、注意不符合切割条件的输入n，以及输入为2、3长度时的结果，因为题中规定m>1。

动态规划
030-连续子数组的最大和
052-正则表达式匹配(我用的暴力)

回溯
065-矩阵中的路径(BFS)
066-机器人的运动范围(DFS)


**牛客网刷题指南：**

**数据结构类题目**
LinkedList
003-从尾到头打印链表
014-链表中倒数第k个结点
015-反转链表
016-合并两个或k个有序链表
025-复杂链表的复制
036-两个链表的第一个公共结点
055-链表中环的入口结点
056-删除链表中重复的结点

Tree
004-重建二叉树
017-树的子结构
018-二叉树的镜像
022-从上往下打印二叉树
023-二叉搜索树的后序遍历序列024-二叉树中和为某一值的路径026-二叉搜索树与双向链表038-二叉树的深度039-平衡二叉树057-二叉树的下一个结点058-对称的二叉树059-按之字形顺序打印二叉树060-把二叉树打印成多行061-序列化二叉树062-二叉搜索树的第k个结点Stack & Queue005-用两个栈实现队列020-包含min函数的栈021-栈的压入、弹出序列044-翻转单词顺序列(栈)064-滑动窗口的最大值(双端队列)Heap029-最小的K个数Hash Table034-第一个只出现一次的字符图065-矩阵中的路径(BFS)066-机器人的运动范围(DFS)具体算法类题目斐波那契数列007-斐波拉契数列008-跳台阶009-变态跳台阶010-矩形覆盖搜索算法001-二维数组查找006-旋转数组的最小数字（二分查找）037-数字在排序数组中出现的次数（二分查找）全排列027-字符串的排列动态规划030-连续子数组的最大和052-正则表达式匹配(我用的暴力)回溯065-矩阵中的路径(BFS)066-机器人的运动范围(DFS)排序035-数组中的逆序对(归并排序)029-最小的K个数(堆排序)029-最小的K个数(快速排序)位运算011-二进制中1的个数012-数值的整数次方040-数组中只出现一次的数字其他算法002-替换空格013-调整数组顺序使奇数位于偶数前面028-数组中出现次数超过一半的数字031-整数中1出现的次数（从1到n整数中1出现的次数）032-把数组排成最小的数033-丑数041-和为S的连续正数序列(滑动窗口思想)042-和为S的两个数字(双指针思想)043-左旋转字符串(矩阵翻转)046-孩子们的游戏-圆圈中最后剩下的数(约瑟夫环)051-构建乘积数组

# 参考书籍
算法图解：https://book.douban.com/subject/26979890/
编程珠玑

算法可视化：https://www.cs.usfca.edu/~galles/visualization/Algorithms.html

做题，分类：
- 基础算法题。其中有大量的算法题，解这些题都是有套路的，不是用递归(深度优先 DFS， 广度优先 BFS)，就是要用动态规划(Dynamic Programming)，或是折半查找(Binary Search)，或是回溯(Back tracing)，或是分治法(Divide and Conquer)，还有大量的 对树、数组、链表、字符串和 hash 表的操作。通过做这些题能让你对这些最基础的算法的 思路有非常扎实的了解和训练。对我而言，Dynamic Programming 是我的短板，尤其是一 些比较复杂的问题，在推导递推公式上总是有思维的缺陷(数学是我的硬伤)。做了这些题 后，我能感到我在动态编程的思路上受到了很大的启发。
- 编程题。比如:atoi，strstr，add two nums，括号匹配，字符串乘法，通配符匹配，文件 路径简化，Text Justification，反转单词等，这些题的 Edge Case 和 Corner Case 有很 多。这些题需要你想清楚了再干，只要你稍有疏忽，就会有几个 case 让你痛不欲生，而且一 不小心就会让你的代码写得又臭又长，无法阅读。通过做这些题，可以非常好地训练你对各 种情况的考虑，以及你对程序代码组织的掌控(其实就是其中的状态变量)。