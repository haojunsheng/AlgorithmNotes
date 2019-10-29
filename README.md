# AlgorithmNotes

好的参考资料。

<https://soulmachine.gitbooks.io/algorithm-essentials/content/java/>

常见的**数据结构**：**链表，树**，栈，队列以及哈希表。（手动实现一下常见的数据结构）

链表的插入和删除节点，二叉树的各种遍历算法的循环和递归的写法需要烂熟于心。

常见的算法：查找（二分查找）和排序（归并排序和快速排序）。

​	![](https://raw.githubusercontent.com/Anapodoton/ImageHost/master/img/20190916200457.png)

# 1. 数据结构

常见的**数据结构**：**链表，树**，栈，队列以及哈希表。（手动实现一下常见的数据结构）

链表的插入和删除节点，二叉树的各种遍历算法的循环和递归的写法需要烂熟于心。

## 1.1 数组

[数组中重复的数字1(3)](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/DuplicationInArray_0301.java)

(找规律)

[数组中重复的数字2(3)](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/DuplicationInArrayNoEdit_0302.java)

（二分查找）技巧需要掌握，考察了**二分查找算法**，不只有序的数组可以使用二分查找，其变形题目也可以。

[二维数组中的查找(4)](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/FindInPartiallySortedMatrix_04.java)
(找规律)本题的规律在于矩阵右上角和左下角比较特殊，比该行所有元素大，比该列所有元素小。而左上角没有这样的规律。


[旋转数组旋转数组的最小数字（11）](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/sortAndFind/MinNumberInRotatedArray_11.java)
本题还属于二分查找算法。


[调整数组顺序使奇数位于偶数前面(21)](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/ReorderArray_21.java)
双指针法，一般就是找规律和空间换时间。

[数组中出现次数超过一半的数字(39)](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/OverHalfInArray_39.java)

[最小的k个数（40）](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/highQuality/KLeastNumbers_40.java)
**partition，即分治算法，十分的重要。可以用在快排算法中，还可以用来实现在长度为n的数组中查找第k大的数字**比如，面试题39，数组中出现次数超过一半的数字和面试题40，最小的k个数。其中，**我们有成熟的算法的时间复杂度为O(n)得到数组中任意第k大的数字，假设你选择的数字p在快排一轮完成后下标是m，那么比p小的数字就有m个，如果k小于m，那么第k大的数字一定在p的左边，否则在右边。**

--- 这里----
[连续子数组的最大和42](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/GreatestSumOfSubarrays_42.java)

[把数组排成最小的数45](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/SortArrayForMinNumber_45.java)
考察了大数问题，以及自定义排序规则

[数字在排序数组中出现的次数53](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/NumberOfK_5301.java)
**看见有序，肯定就是二分查找了。** 二分查找十分的重要。

[数组中只出现一次的数字56](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/NumbersAppearOnce_5601.java)
这个类型的题目还是比较有意思的，可以借助于位运算优化时间复杂度和空间复杂度，用来解决其他数字出N（N>=2）次，而一个数字出现1次都可以用这种解法来推导出这个出现1次的数字。

需要注意的是，数组中只出现一次的两个数字，其他的数字都出现了两次。这个题目要把数组分成两部分来解决。

[构建乘积数组66](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/ConstuctArray_66.java)



## 1.2 字符串

> 字符串经典的题目有字符串排序，单词查找树，子字符串查找，正则表达式和数据压缩。

[String源码相关](https://www.hollischuang.com/archives/99)



[替换空格5](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/ReplaceSpaces_05.java)

[技巧：从前向后需要移动多次，则从后向前移动]。

同时需要警惕内存覆盖的情况，如果字符串可能会变长，那么我们必须考虑这种情况。

【相关题目：】两个排序数组A1和A2，把A2中的所有数字插入A1中。 解决思路也是：**从尾到头进行比较**。

【总结：】在合并两个数组或者字符串的时候，如果从前向后复制每个数字需要移动数字多次，那么我们可以考虑从后向前复制，这样可以减少移动的次数，从而提高效率。





[正则表达式匹配19](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/RegularMatch_19.java)

[表示数值的字符串20](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/NumericStrings_20.java)

[字符串的排列38](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/StringPermutation_38.java)

[第一个只出现一次的字符50](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/FirstNotRepeatingChar_50.java)

[左旋转字符串58](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/LeftRotateString_5802.java)

[翻转单词顺序序列46 ，58](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/ReverseWordsInSentence_58.java)

[把字符串转换成整数67](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/string/StringToInt_67.java)



## 1.3 链表

[链表](https://github.com/Anapodoton/JavaLearning/blob/master/Java基础知识/Java中的容器/集合大家族.md)

简单题目：
递归和栈的知识。

[从尾到头打印链表6](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/PrintListInReversedOrder_06.java)

【知识点】考察了对循环，递归和栈这3个相互关联的概念的理解。

思路：
  从尾到头打印列表
  第一种方法是把链表就地反转，但是这样会修改原来的链表，一般不这样做
  第二种：顺序遍历，逆序打印，发现和栈的结构是一样的，所以可以使用栈来实现
  第三种：栈的本质就是递归，所以也可以使用递归来实现。



[面试题18：删除链表中的节点](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/DeleteNodeInList_18.java)
思路：把下一个节点的值保存到该节点，然后删除下一个节点即可，需要考虑只有一个节点和删除尾节点的特殊情况。

[面试题：删除链表中的重复节点](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/deleteDuplication.java)
思路：保存要比较节点的前一个节点，需要注意：重复节点的位置（头部，中间和尾部）。


[面试题22：链表中倒数第k个节点](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/KthNodeFromEnd_22.java)

当在链表中一个指针不能解决问题的时候，可以尝试使用两个指针来遍历，其中一个指针的速度快点，另外一个指针的速度慢点，或者一个先走，另一个后走。
详见面试题22。

举一反三：求链表的中间节点。我们的思路是：一个指针每次走两步，另一个走一步，快的走到末尾的时候，慢的恰好在中间。


[面试题24：反转链表](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/ReverseList_24.java)
循环和递归两种方法都要会。

[面试题25：合并两个排序链表](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/MergeList_25.java)
循环和递归两种方法都要会。


[面试题52：两个链表的第一个公共节点](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/FirstCommonNodesInLists_52.java)
可以暴力去解，需要时间复杂度为O(mn)
还可以使用栈的特性，思路是倒着找，因为如果有相同的，最后一个肯定是相同的。
最好的思路是一个指针先走，另一个指针后走。

[面试题62：圆圈中最后剩余的数字](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/LastRemaining_62.java)

【题型】把链表的末尾节点的指针指向头结点，从而形成一个环形链表。

本质上是约瑟夫环问题,解决思路：

 1. 用环形链表去模拟
 2. 找出相应的数学规律
     f[1]=0;
     f[i]=(f[i-1]+m)%i;  (i>1)

[面试题35：复杂链表的复制](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/linkedList/CopyList_35.java)

【题型：复杂链表】链表中的节点除了有指向下一个节点的指针，还有指向任意一个节点的指针。

考察把复杂问题分解的能力，用到了空间换时间的思想，能够在O(1)的时间复杂度找到下一个随机节点。

[面试题36：二叉搜索树与双向链表](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/BinaryTreeConvert_36.java)
双向链表

【题型：双向链表】链表中的节点除了有指向下一个节点的指针，还有指向前一个节点的指针。



## 1.4 二叉树&递归

二叉查找树（也叫二叉搜索树，BST），平衡二叉树（AVL树），并查集，堆，哈夫曼树。

前序，中序和后序，每种都有递归和循环，共六种考察方法。

此外还有宽度优先。



**二叉树的深度优先遍历**

[重建二叉树7](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/ConstructBinaryTree_07.java)

【思路】用到了递归的知识。（大问题分解为小问题，大问题和小问题本质上是一致的。）                                                                                             

[面试题8:二叉树的下一个节点](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/NextNodeInBinaryTrees_08.java)

【思路】考察了二叉树的遍历算法，需要进行归纳总结出相应的规律。

[面试题26：树的子结构](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/IsSubTree_26.java)

[面试题27：二叉树的镜像](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/MirrorTree_27.java)

[面试题28：对称的二叉树](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/SymmetricalBinaryTree_28.java)


[面试题33：二叉搜索树的后序遍历](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/SquenceOfBST_33.java)

[面试题34：二叉树中和为某值的路径](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/PathInTree_34.java)


[面试题55：二叉树的深度,平衡二叉树](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/TreeDepth_5501.java)
在遍历二叉树的时候，优化的算法一般是每个节点尽量只遍历一次，不要进行重复遍历，而且在遍历的时候，要及时进行剪枝，如果结果已经出现，要及时的进行返回。

宽度优先遍历：
[面试题32：从上向下打印二叉树,分行，不分行，按之字形顺序打印二叉树](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/ConstructBinaryTree_07.java)

二叉树的特例：二叉搜索树。搜索时间复杂度logn

[面试题36：二叉搜索树与双向链表](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/BinaryTreeConvert_36.java)


[面试题68：树中两个节点的最低公共祖先](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/ConstructBinaryTree_07.java)

二叉树的特例：堆分为最大堆和最小堆。（用来快速查找最大值或者最小值）

二叉树的特例：红黑树（确保从根节点到叶节点的最长路径的长度不超过最短路径的2倍）

[面试题40：最小的k个数](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/KLeastNumbers_40.java)



[面试题54：二叉搜索树的第k大节点](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/tree/KthNodeInBST_54.java)





## 1.5 栈和队列

在O(1)的时间得到栈的最大值和最小值。[包含min函数的栈30](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/stack/CustomStack_30.java)



32从上到下打印二叉树，树的宽度遍历算法。



[使用两个栈实现队列9](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/stack/QueueWithTwoStacks_09.java)

【知识点】队列的特性和栈的特性。

【思路】根据题意，进行画图总结。

【相似】[队列的最小修改-京东前端](https://www.nowcoder.com/practice/02f2bbaadbcf424b8cbc7e264ddef9b4)



005-用两个栈实现队列
020-包含min函数的栈
021-栈的压入、弹出序列
044-翻转单词顺序列(栈)
064-滑动窗口的最大值(双端队列)





[栈的压入、弹出序列31](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/stack/StackSequence_31.java)

Heap（牛客网顺序）
029-最小的K个数
Hash Table
034-第一个只出现一次的字符
图
065-矩阵中的路径(BFS)
066-机器人的运动范围(DFS)







# 2. 算法

**常用的算法：大多数是基于查找和排序。**
递归的核心思想是如果要求f(n),那么我只需要知道f(n-1)即可。循环的核心思想是要求f(n),我可以从f(1)一直求到f(n)。

我们应该重点掌握**二分查找，归并排序和快速排序**。这三种必须可以手撕代码。
如果面试题要求在排序的数组或者部分排序的数组中查找一个数字或者统计某数字出现的次数，可以尝试使用二分查找算法。

在查找中，哈希表和二叉排序树的考察重点在数据结构上，而不是算法上。哈希表的时间复杂度为O(1)，原理是空间换时间，题目代表50“第一个只出现一次的字符”，可以关注布隆过滤器的实现。

在排序中，需要掌握各种排序算法的平均时间复杂度，最差时间复杂度，空间复杂度，另快排是十分重要的。
快排的核心是随机选择一个数字，比这个数字大的移动到左边，比这个数字小的移动到右边。可以用递归和循环来实现。

当题目要求在二维数组上（迷宫或者棋盘）上搜索路径，我们可以尝试使用回溯法，很适合采用递归的手段来实现。
如果明确指出不可以使用递归的话，可以使用栈来模拟递归。

回溯法是升级版的暴力法，从解决问题的每一步的所有可能选项选出一项，然后进入下一步，进行重复选择，直到最终状态。（在到达递归边界前的某层，由于一些事实不需要向任何一个子问题进行递归，直接返回上一层，这种做法称为回溯法，本质上也是递归）。

动态规划和贪心算法。
动态规划用于求某个问题的最优解(通常是最大值和最小值)，并且该问题可以分解为多个子问题。
需要符合两个特点：1.求最优解，即求最值。2.整体的最优解依赖于各个子问题的最优解。3.子问题之间有相互重叠的更小的子问题。4.根据第三点，子问题之间有重叠，所以从上向下分析问题，从下向上求解问题。

位运算：与，或，异或，左移和右移。
需要关注的是右移，分为有符号和无符号两种，如果是无符号，则直接用0填补左边的n位，如果是有符号的负数，如10001010 >> 3= 11110001
把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0。也是很多二进制问题的解决思路。

自上而下的分析问题，自下而上的解决问题。

## 2.1 查找和排序

[数组中重复的数字(3)](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/array/DuplicationInArray_0301.java)

技巧需要掌握，考察了**二分查找算法**，不只有序的数组可以使用二分查找，其变形题目也可以。



二分查找：

[旋转数组的最小数字(11)](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/sortAndFind/MinNumberInRotatedArray_11.java)

【题型】二分查找算法

在排序数组中查找数字(53)



第一个只出现一次的字符(50)



二叉搜索树的后序遍历序列(33)

二叉搜索树与双向链表(36)



快排的思想：Partition算法，可以用来进行快排，还可以用在 「在长度为n的数组中查找第k大的数字」，比如：

数组中出现次数超过一半的数字(39), 最小的k个数(40)。



## 2.2 递归和循环

详细分析递归和循环的性能和区别：

[斐波拉契数列10](https://github.com/Anapodoton/JavaLearning/blob/master/CodingInterview/src/com/code/sortAndFind/Fibonacci_10.java)

【注意】这个题目是很简单的，但是我们要注意的是：整数溢出的问题。所以需要用BigInterger来解决。

【相似题目】[求和-好未来-中等](https://www.nowcoder.com/practice/11cc498832db489786f8a03c3b67d02c)

  



n个骰子的点数60

动态规划类的问题基本都是递归的思想来进行解决的，但是递归分解的问题容易产生大量的重复，所以我们用递归来分析问题，用循环来写代码。面试题14“剪绳子”，面试题47“礼物的最大价值”，面试题48“最长不含重复字符的子字符串”。



数值的整数次方（面试题16）



## 2.3 回溯法

树形结构值得学习。



矩阵中的路径12 

机器人的运动范围13

【题型：回溯法】回溯法和DFS很像，所有的选项可以形象的用树状结  构来表示。通常二维矩阵上找路径的问题都可以使用回溯法来解决。



# 2.4 动态规划与贪婪算法

 动态规划和贪心算法。
动态规划用于求某个问题的最优解(通常是最大值和最小值)，并且该问题可以分解为多个子问题。
需要符合两个特点：1.求最优解，即求最值 。2.整体的最优解依赖于各个子问题的最优解。3.子问题之间有相互重叠的更小的子问题。4.根据第三点，子问题之间有重叠，所以从上向下分析问题，从下向上求解问题。



贪心算法需要从数学上进行证明。



剪绳子