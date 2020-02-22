算法第四版笔记。

# 前言

# 2. 排序

排序算法可以按照类别进行分类，比如交换类（冒泡，快排），选择类（简单选择，堆排序）和插入类（直接插入，希尔）。

## 2.1 初级排序算法

模板

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191223202420.png" style="zoom:50%;" />

### 2.1.2 选择排序

我们先来看选择排序。思路是这样的：找到数组中最小的元素，和第一个元素交换位置；剩下的元素中，找到最小的，和第二个交换，直到完成排序。这就是选择排序名字的来源，**不断的选择剩余元素的最小值**。

![](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191223202108.png)

特点有2个，运行时间和输入无关，这个是很大的缺点；移动次数最少，其他的算法都不具备这个特征。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191223202316.png" style="zoom:50%;" />

[SelectionCode](https://algs4.cs.princeton.edu/21elementary/Selection.java.html)

### 2.1.3 插入排序

插入排序是另外一个初级算法。<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191223202644.png" style="zoom:50%;" />

插入排序和选择排序相比，移动次数是较多的，和输入有关，有序比随机和逆序要好。<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191223202852.png" style="zoom:50%;" />

[Insertion.java](https://algs4.cs.princeton.edu/21elementary/Insertion.java.html)

插入排序的适用情况是：

- 数组中每个元素距离它的最终位置都不远；
- 一个有序的大数组接一个小数组；
- 数组中只有几个元素的位置不正确。

注意，我们实现的插入排序，总是交换2个元素，事实上，我们最好是在内循环中，将较大的元素尽可能向右移动，这样可以将数组的访问次数减半。

### 2.1.6 希尔排序

我们将尝试基于插入排序研发出一种更快的算法。我们来思考这个一个场景，大规模的乱序数组是很慢的，因为只会交换相邻的元素。为了进行改进，我们改进了插入排序：**交换不相邻的元素以对数组的局部进行排序，并最终用插入排序来将局部有序的数组排序。**

希尔排序的思想是数组中任意间隔为h的元素是有序的。<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191223210906.png" style="zoom:50%;" />

希尔排序高效的原因是权衡了**数组的规模和有序性**。结合我们之前所讲的，排序之前，各个子数组都很短，排序之后子数组都是部分有序的，都适合采用插入排序。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224104723.png" style="zoom:50%;" />

[Shell.java](https://algs4.cs.princeton.edu/21elementary/Shell.java.html)

其实递增序列的选择是十分困难的，很多论文在研究，但是没有回答这个问题。最坏的时间复杂度是N^1.5,很牛逼了，一个小小的改变，就突破了平方级别的时间复杂度。

对于中等大小的数组来讲，运行时间是可以接受的，代码量小，且无额外的内存空间。很优秀。

### 2.1.7练习

喜闻乐见的练习环节。

2. What is the maximum number of exchanges involving any particular item during selection sort? What is the average number of exchanges involving an item?

*Solution.* The average number of exchanges is exactly 1 because there are exactly N exchanges and N items. The maximum number of exchanges is N, as in the following example.



可以省略判断条件的元素被称为哨兵。

## 2.2 归并排序

这个玩意，还是有点复杂的。基于归并这个操作，将两个有序的数组归并成一个更大的有序数组。举个例子，我们想要排序，可以把数组递归的分成两半，分别进行排序，然后把结果合并起来。**优点是把任意长度为N的数组排序时间和NlogN成正比。缺点是需要额外的空间和N成正比。**

### 2.2.1 原地归并的抽象方法

想一下这么一个场景，我们使用归并算法来排序一个大数组时，需要多次归并，因此每次归并我们都会创建一个新的数组来存放排序结果，太tm的浪费内存了。那么我们能不能直接进行原地归并：前半部分排序，后半部分排序，然后在数组中移动元素，从而减少内存的使用。<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224120245.png" style="zoom:50%;" />

[Merge.java](https://algs4.cs.princeton.edu/22mergesort/Merge.java.html)

### 2.2.2 自顶向下的归并排序



<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224120420.png" style="zoom:50%;" />

[Merge.java](https://algs4.cs.princeton.edu/22mergesort/Merge.java.html)

看下其排序的调用轨迹：

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224120646.png" style="zoom:50%;" />

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224120827.png" style="zoom:50%;" />

### 2.2.4 自底向上的归并排序

上面我们考虑的是把一个大问题分解为小问题分别解决，然后用小问题的答案来解决整个大问题。那么我们能不能换个思路，先归并微型数组，然后在成对归并子数组，直到整个数组全部归并完成。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224123029.png" style="zoom:50%;" />

[MergeBU.java](https://algs4.cs.princeton.edu/22mergesort/MergeBU.java.html)

总结：归并排序是一种渐进最优的基于比较排序的算法。可以证明的是：归并排序在最坏的情况下的比较次数和任意基于比较的排序算法所需的最少比较次数是NlgN。

## 2.3 快速排序

我们来看快排，快排把**原地排序（只需要很小的辅助栈），NlgN的时间复杂度**，两个优点结合了起来。缺点是太过于脆弱。

### 2.3.1 基本算法

分而治之，数组分为2部分，2部分独立的进行排序。

发现没，和归并很像哎。前者是把数组分为2个子数组分别排序，并且将有序的子数组归并将整个数组进行排序；后者强调的是  当两个子数组都有序了，整个数组也就有序了。具体来讲，**其区别在于前者递归在处理数组之前；后者递归在处理数组之后**。前者数组被等分，后者partition的位置取决于数组的内容。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224204740.png" style="zoom:50%;" />

[QuickSort.java](https://algs4.cs.princeton.edu/23quicksort/Quick.java.html)

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191224205620.png" style="zoom:50%;" />

由于快速排序在某些情况下，并不是最好的，所以我们可以进行优化：

切换到插入排序，小数组的情况下，应该使用插入排序。

### 2.3.2 性能特点

第一个优势是：快排的内循环会引用一个递增的索引将数组元素和一个定值比较。这是快排的优点，例如，归并和希尔一般比快排慢，原因在于在内循环中移动了数据。

另外一个优势是比较的次数少。

当然，快排的最好情况是每次恰好把数组对半分开。<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191225195520.png" style="zoom:50%;" />

## 2.4 优先队列

我们可以使用二叉堆构造一个优先队列，用来高效的删除最大元素和插入元素。

我们可以基于堆的优先队列来实现堆排序，也可以用来实现图的搜索算法，还可以用来实现数据压缩算法。

### 2.4.1 API



<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191225204052.png" style="zoom:50%;" />

### 2.4.2 初级实现

我们可以分别:数组实现（无序，基于下压栈），数组实现（有序），链表表示法。进行比较：

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191225204812.png" style="zoom:50%;" />

### 2.4.3 堆的定义

根节点是堆有序的二叉树中的最大节点。

### 2.4.4 堆的算法

下面我们来看堆的算法。

我们分为由下到上的有序化，和由上到下的有序化。

### 2.4.5 堆排序

接着来看堆排序。堆排序分为2个阶段，堆的构造阶段(原始数组重新放到一个堆中)，下沉排序阶段。

## 2.5 应用

排序算法和优先队列有很多的应用。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191226102404.png" style="zoom:50%;" />

快速排序是最快的通用排序算法。但是，如果稳定性很重要，空间不重要的话，归并排序是最好的。

下面我们来看问题的归约，问题的归约是十分重要的。归约指的是为解决某个问题而发明的算法正好可以用来解决另一种问题。如下面的问题都可以归约为排序问题：

- 找出重复元素;
- 排名
- 优先队列
- 中位数与顺序统计
  - 第k小的元素：
    - 可以使用TopK算法
    - 也可以直接排序
    - 还可以使用快排的切分来查找中位数

# 3. 查找

## 3.1 符号表

把键和值进行了关联。

### 3.1.1 API

![](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191226200025.png)

### 3.1.2 有序符号表



### 3.1.4 无序链表中的顺序查找



### 3.1.5 有序数组中的二分查找

比较有效的数据结构是二叉查找树，数组在插入的场景下并不方便。

![](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/20191226200604.png)

## 3.2 二叉查找树

二叉查找树是很牛逼的，既保留了链表插入的灵活性，也保留了有序数组查找的高效性。



































