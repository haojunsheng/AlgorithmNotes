# 前言

# 1. 复杂度分析

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201102155642.png" alt="image-20201102155630404" style="zoom:33%;" />

此外，我们还需要了解最好，最坏，平均，均摊时间复杂度。

# 2. 数组

我们需要关注数组的实现原理，随机访问的原理，数组的访问越界，容器和数组的优劣。

为什么数组的下标从0开始？

因为下标的含义是**偏移**，如果从1开始，则需要多计算一次减法。

```
a[k]_address = base_address + k * type_size
a[k]_address = base_address + (k-1)*type_size
```

# 3. 链表

需要了解链表底层的实现原理，单链表，循环链表（约瑟夫环问题），双向链表。

[常见链表操作](https://github.com/haojunsheng/AlgorithmNotes/blob/master/src/com/code/geekbang/linklist_07/LinkedListAlgo.java) 

常见的边界条件：

如果链表为空时，代码是否能正常工作?

 如果链表只包含一个结点时，代码是否能正常工作? 

如果链表只包含两个结点时，代码是否能正常工作? 

代码逻辑在处理头结点和尾结点的时候，是否能正常工作?

# 4. 栈

使用场景:**栈在函数调用中的应用**，**表达式求值中的应用**，**括号匹配中的应用**，

注意：JVM中的堆栈和数据结构中的堆栈不是一回事。

# 5. 队列

阻塞队列：

![image-20201103144443748](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201103144546.png)

![image-20201103144517985](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201103144535.png)

# 6. 递归

> 不要陷入细节

**写递归代码的关键就是找到如何将大问题分解为小问题的规律，并且基于此写 出递推公式，然后再推敲终止条件，最后将递推公式和终止条件翻译成代码**。**只要遇到递归，我们就把它抽象成一个递推公式，不用想一层层的调用关系，不要试图用人脑去分解递归的每个步骤**。

问题：

- 堆栈溢出
- 重复计算

**调试递归:**
1.打印日志发现，递归值。
2.结合条件断点进行调试。

# 7. 排序

衡量排序算法：

- 执行效率：
  - 最好，最坏，平均时间复杂度
  - **比较次数和交换(或移动)次数**
- 内存消耗：原地排序（空间复杂度为O(1)）
- 稳定性

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201103153239.png" alt="image-20201103153112826" style="zoom:50%;" />

- 归并排序：分而治之的思想，**分治是一种解决问题的处理思想，递归是一种编程技巧**。

归并排序的时间复杂度推导：

假设a问题可以分解为问题b和c，则T(a) = T(b) + T(c) + K，k代表合并b和c问题所需的时间复杂度。对于归并排序：

```
T(1) = C
T(n) = 2*T(n/2) + n; n>1
```

则：

```
T(n) = 2*T(n/2) + n
= 2*(2*T(n/4) + n/2) + n = 4*T(n/4) + 2*n
= 4*(2*T(n/8) + n/4) + 2*n = 8*T(n/8) + 3*n
= 8*(2*T(n/16) + n/8) + 3*n = 16*T(n/16) + 4*n 
......
= 2^k * T(n/2^k) + k * n
......
```

当 T(n/2^k)=T(1) 时，也就是 n/2^k=1，我们得到 k=logn ，所以T(n) = O(nlogn)。空间复杂度是O(n)，因为数组合并后就会被释放掉。

- 快排

快排的优化，退化的主要原因是分区点选择的不合理，所以最理想的分区点是：**被分区点分开的两个分区中，数据的数量差不多**。常见的方案有：

三数取中法：从区间的首、尾、中间，分别取出一个数，然后对比大小，取这 3 个数的中间值作为分区点。

随机法。



## 线性排序

线性排序：非基于比较的排序算法，都不涉及元素之间的比较操作。

- 桶排序（**Bucket sort**）

![image-20201104143538808](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104143538.png)

分析时间复杂度：

![image-20201104143757723](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104143757.png)

桶排序适合用在外部排序算法中：

举例：比如说我们有 10GB 的订单数据，我们希望按订单金额(假设金额都是正整数)进行排 序，但是我们的内存有限，只有几百 MB，没办法一次性把 10GB 的数据都加载到内存 中。这个时候该怎么办呢?

解决：我们可以先扫描一遍文件，看订单金额所处的数据范围。假设经过扫描之后我们得到，订单 金额最小是 1 元，最大是 10 万元。我们将所有订单根据金额划分到 100 个桶里，第一个 桶我们存储金额在 1 元到 1000 元之内的订单，第二桶存储金额在 1001 元到 2000 元之内 的订单，以此类推。每一个桶对应一个文件，并且按照金额范围的大小顺序编号命名 (00，01，02...99)。

理想的情况下，如果订单金额在 1 到 10 万之间均匀分布，那订单会被均匀划分到 100 个 文件中，每个小文件中存储大约 100MB 的订单数据，我们就可以将这 100 个小文件依次 放到内存中，用快排来排序。等所有文件都排好序之后，我们只需要按照文件编号，从小到 大依次读取每个小文件中的订单数据，并将其写入到一个文件中，那这个文件中存储的就是 按照金额从小到大排序的订单数据了。

不过，你可能也发现了，订单按照金额在 1 元到 10 万元之间并不一定是均匀分布的 ，所 以 10GB 订单数据是无法均匀地被划分到 100 个文件中的。有可能某个金额区间的数据特 别多，划分之后对应的文件就会很大，没法一次性读入内存。这又该怎么办呢?

针对这些划分之后还是比较大的文件，我们可以继续划分，比如，订单金额在 1 元到 1000 元之间的比较多，我们就将这个区间继续划分为 10 个小区间，1 元到 100 元，101 元到200 元，201 元到 300 元...901 元到 1000 元。如果划分之后，101 元到 200 元之间的订 单还是太多，无法一次性读入内存，那就继续再划分，直到所有的文件都能读入内存为止。

- 计数排序（**Counting sort**）

**计数排序其实是桶排序的一种特殊情况**。当要排序的 n 个数据，所处的范围并不大的时候，比如最大值是 k，我们就可以把数据划分成 k 个桶。每个桶内的数据值都是 相同的，省掉了桶内排序的时间。

**计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。而且，计数排序只能给非负整数排序，如果要排序的数**据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。

- 基数排序（**Radix sort**）

可以用在手机号排序的场景中，**基数排序对要排序的数据是有要求的，需要可以分割出独立的“位”来比 较，而且位之间有递进的关系，如果 a 数据的高位比 b 数据大，那剩下的低位就不用比较 了。除此之外，每一位的数据范围不能太大，要可以用线性排序算法来排序，否则，基数排序的时间复杂度就无法做到 O(n) 了**。

## 实际的排序函数

![image-20201103154648229](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201103154911.png)

如何实现一个通用的排序算法?

- 线性排序的时间复杂度低，但是适用场景比较特殊；
- 小规模数据，可以选择O(n^2)的排序算法；
- 大规模的，选择O(nlgn)的
  - C语言选择快排
  - Java选择堆排序
  - 一般不选择归并排序，虽然归并排序比较稳定，但是不是原地排序算法，空间复杂度为O(n)。

# 8. 二分查找

二分查找的变形：

- **查找第一个值等于给定值的元素**
- **查找最后一个值等于给定值的元素**
- **查找第一个大于等于给定值的元素**
- **查找最后一个小于等于给定值的元素**

查找IP的归属地：先把IP转换为int进行保存，然后把int进行排序，所以题目就可以 =》在有序数组中，查找最后一个小于等于某个给定值的元素（因为IP地址可能会更新）。

# 9. 跳表

> 数据存储在链表中，如何才能够使用二分查找算法？这就是跳表skiplist。

跳表性能堪比红黑树，redis中的sort-set就是用跳表来实现的。

跳表是什么？我们为什么需要跳表呢？

我们知道，二分查找的时间复杂度为lgn，性能是很好的，但是其只能局限在数组中，链表是不能使用二分查找的。那么有没有办法在链表中实现**二分查找**的特性呢？

如果数据是有序的，还是需要O(n)的时间复杂度。

![image-20201104215838708](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104215838.png)

那怎么提高查找效率呢？每两个结点提取一个结点到上一级。

![image-20201104220146993](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104220212.png)

类推：

![image-20201104220326454](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104220326.png)

所以，当链表的长度 n 比较大时，在构建索引之后，查找效率的提升就会非常明显。直观上，我们可以看到查找的效率提高了提高，下面让我们来具体分析提高的效率。

假设链表的长度为n，那么第一级索引的节点个数为n/2，第二级为n/4,那么第k级索引的节点个数为n/(2^k)。我们知道，最高的索引有2个节点，则k=lgn-1。在我们查询数据的时候，如果每一层需要查找m个节点，则在跳表中查询一个数据的时间复杂度就是 O(m*logn)。

且m=3，则时间复杂度为O(lgn)。

原因如下：假设我们要查找的数据是 x，在第 k 级索引中，我们遍历到 y 结点之后，发现 x 大于 y，小 于后面的结点 z，所以我们通过 y 的 down 指针，从第 k 级索引下降到第 k-1 级索引。在 第 k-1 级索引中，y 和 z 之间只有 3 个结点(包含 y 和 z)，所以，我们在 K-1 级索引中 最多只需要遍历 3 个结点，依次类推，每一级索引都最多只需要遍历 3 个结点。

![image-20201104224116884](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104224136.png)

我们可以看到，通过建立索引，我们实现了快速查找，代价了浪费了空间，空间复杂度为O(n)。其实在实际的软件开发中，链表中存储的是比较大的对象，但是索引中存储的是id，所以相比较之下是可以忽略的。

下面我们来分析插入和删除的时间复杂度，先给结论，也是O(lgn)。

![image-20201104225433740](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104225433.png)

我们还需要注意的是要及时更新索引,红黑树是通过左右旋来保持稳定的，而跳表是通过随机函数来保存平衡性的。

![image-20201104230124109](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201104230124.png)

我们来看为什么Redis的有序集合使用跳表呢？

因为有序集合支持按照区间查找数据，可以做到 O(logn) 的时间复杂度定位区间的起点， 然后在原始链表中顺序往后遍历就可以了。

# 10. 散列表

散列表+链表的威力：

- 我们可以借助于散列表+链表把LRU 的时间复杂度降低到O(1)。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105000447.png" alt="image-20201105000447511" style="zoom:50%;" />

我们使用双向链表存储数据，链表中的每个结点处理存储数据(data)、前驱指针 (prev)、后继指针(next)。因为我们的散列表是通过链表法解决散列冲突的，所以每个结点会在两条链中。一个链是刚刚我们提到的**双向链表**，另一个链是散列表中的**拉链**。**前驱和后继指针是为了将结点串在双 向链表中，hnext 指针是为了将结点串在散列表的拉链中**。

我们来看**如何查找一个数据**。我们前面讲过，散列表中查找数据的时间复杂度接近 O(1)，所以通过散列表，我们可以很快地在缓存中找到一个数据。当找到数据之后，我们 还需要将它移动到双向链表的尾部。

我们来看**如何删除一个数据**。我们需要找到数据所在的结点，然后将结点删除。借助 散列表，我们可以在 O(1) 时间复杂度里找到要删除的结点。因为我们的链表是双向链表， 双向链表可以通过前驱指针 O(1) 时间复杂度获取前驱结点，所以在双向链表中，删除结点 只需要 O(1) 的时间复杂度。

我们来看**如何添加一个数据**。添加数据到缓存稍微有点麻烦，我们需要先看这个数据 是否已经在缓存中。如果已经在其中，需要将其移动到双向链表的尾部;如果不在其中，还 要看缓存有没有满。如果满了，则将双向链表头部的结点删除，然后再将数据放到链表的尾 部;如果没有满，就直接将数据放到链表的尾部。

- Redis有序集合

# 11. hash算法

hash算法的应用：

- 安全加密
- 唯一标识
- 数据校验
- 散列函数
- 负载均衡
- 数据分片
- 分布式存储

# 12. 二叉树

二叉树的存储方式，一般是用链表来存储，但是完全二叉树可以使用数组来存储，比较节省内存。下面分别是完全二叉树和非完全二叉树使用数组来存储。其实堆就是一种完全二叉树，使用数组来存储。

![image-20201105105808425](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105105808.png)

![image-20201105105919360](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105110018.png)

下面来看二叉树的遍历，前中后序三种遍历方式。时间复杂度为O(n)，原因是每个节点最多被访问2次。

![image-20201105110810954](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105111333.png)



- 满二叉树：

- 完全二叉树：
- 二叉查找树：

为什么hashmap如此高效的情况下，我们还需要二叉查找树呢？

1. 散列表中的数据是无序存储的，若要输出有序数据，则需要先进行排序，而二叉查找树直接中序遍历即可；
2. 散列表扩容耗时多；
3. 散列表在hash冲突的时候耗时多；
4. 散列表的构造复杂，需要考虑散列函数的设计、冲突解决办法、扩容、缩容等问题，而二叉查找树只需要考虑平衡性问题；

# 13. 红黑树

前面我们学到二叉查找树在某些情况下可能会失衡，即退化为链表，时间复杂度降低为O(n),所以我们需要对二叉查找树进行平衡。

最先被使用的是AVL平衡二叉查找树，其首先符合二叉查找树的概念，然后左右子树的高度差不超过1。这样就可以很好的保证查找的时间复杂度了。但是其缺点也是很明显的，需要不断的对整棵树进行调整。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105132230.png" alt="image-20201105132230229" style="zoom:33%;" />

这个时候我们就引入了红黑树：左右子树的高度差不超过1倍。

> 红黑树中的节点，一类被标记为黑色，一类被标记为红色。
>
> 根节点是黑色的; 
>
> 每个叶子节点都是黑色的空节点(NIL)，也就是说，叶子节点不存储数据; （主要是为了简化红黑树的代码实现）
>
> 任何相邻的节点都不能同时为红色，也就是说，红色节点是被黑色节点隔开的; 
>
> 每个节点，从该节点到达其可达叶子节点的所有路径，都包含相同数目的黑色节点;

![image-20201105132916331](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105132950.png)

红黑树的高度，这个比较复杂，是2logn,所以还是logn。其查找，插入，删除的时间复杂度都是O(logn)。

具体的实现可以忽略。

# 14. 递归树

通过递归树来分析递归的时间复杂度，是个不错的办法，因为使用递推公司来分析递归的时间复杂度是个很难的事情。

- 归并排序的时间复杂度

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105144950.png" alt="image-20201105144950058" style="zoom:50%;" />

在归并排序算法中，每次分解的时间复杂度为O(1),耗时的是归并操作，把两个子数组合并为大数组，这个操作和数据规模有关，即每层的耗时都是O(n)，又因为树的高度为logn,所以总的时间复杂度为O(nlogn)。

- 快排的时间复杂度

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105145401.png" alt="image-20201105145243331" style="zoom:33%;" />

我们知道，快排不太可能每次正好分为2半，我们假设分为了1:9,那么树的高度为：

![image-20201105150352688](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105150410.png)

所以平均时间复杂度仍然为nlogn。

- 斐波那契的时间复杂度

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105150519.png" alt="image-20201105150519413" style="zoom:50%;" />

第一层耗时1，第二层为2，第三层为4，则最后一次为2^(n-1)，^所以总共为1+2+4+2^(n-1)= 2^n -1

- 全排列

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105152055.png" alt="image-20201105152055322" style="zoom:50%;" />

第一层分解有n次交换操作，第二层有n个节点，每个节点分解需要 n-1次交换，所 以第二层总的交换次数是 n*(n-1)。所以时间复杂度为O(n!)。

# 15. 堆排序

堆的存储：

![image-20201105153018521](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105153018.png)

![image-20201105153108742](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105153108.png)

下面来看堆的操作：

1. 插入

![image-20201105153251318](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105153251.png)

2. 删除

![image-20201105153431738](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105153431.png)

所以插入和删除的时间复杂度都是O(logn)。

接着来看堆排序。

1. 建堆

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105153647.png" alt="image-20201105153647713" style="zoom:50%;" />

来分析下建堆的时间复杂度：

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105155047.png" alt="image-20201105155047771" style="zoom:50%;" />

即：

![image-20201105155356560](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105155439.png)

![image-20201105155426686](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105155426.png)

又因为h=logn,所以S=O(n)。

2. 排序

建堆结束之后，数组中的数据已经是按照大顶堆的特性来组织的。数组中的第一个元素就是 堆顶，也就是最大的元素。我们把它跟最后一个元素交换，那最大元素就放到了下标为n的位置。

![image-20201105155558104](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105155758.png)

所以时间复杂度为O(nlogn)，空间复杂度为O(1)。

**为什么在工程中跟多的使用快排，而不是堆排序**？

1. **堆排序数据访问的方式没有快速排序友好。**CPU的空间局部性原理。快排中，数据是顺序访问的，而堆中是跳着访问的。

![image-20201105160117032](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105161842.png)

2. 同样的数据，堆排序的交换次数多余快排。



我们接着来看堆的应用。

- 优先级队列:用在赫夫曼编码、图的最短路径、最小生成树算法等地方。

  - 合并有序小文件

  假设我们有 100 个小文件，每个文件的大小是 100MB，每个文件中存储的都是有序的字符串。我们希望将这些 100 个小文件合并成一个有序的大文件。

  答：我们将从小文件中取出来的字符串放入到小顶 堆中，那堆顶的元素，也就是优先级队列队首的元素，就是最小的字符串。我们将这个字符 串放入到大文件中，并将其从堆中删除。然后再从小文件中取出下一个字符串，放入到堆 中。循环这个过程，就可以将 100 个小文件中的数据依次放入到大文件中。

  - 高性能定时器

  假设我们有一个定时器，定时器中维护了很多定时任务，每个任务都设定了一个要触发执行 的时间点。定时器每过一个很小的单位时间(比如 1 秒)，就扫描一遍任务，看是否有任 务到达设定的执行时间。如果到达了，就拿出来执行。但是，这样每过 1 秒就扫描一遍任务列表的做法比较低效，主要原因有两点:第一，任务 的约定执行时间离当前时间可能还有很久，这样前面很多次扫描其实都是徒劳的;第二，每 次都要扫描整个任务列表，如果任务列表很大的话，势必会比较耗时。

  针对这些问题，我们就可以用优先级队列来解决。我们按照任务设定的执行时间，将这些任 务存储在优先级队列中，队列首部(也就是小顶堆的堆顶)存储的是最先执行的任务。这样，定时器就不需要每隔 1 秒就扫描一遍任务列表了。它拿队首任务的执行时间点，与 当前时间点相减，得到一个时间间隔 T。这个时间间隔 T 就是，从当前时间开始，需要等待多久，才会有第一个任务需要被执行。 这样，定时器就可以设定在 T 秒之后，再来执行任务。从当前时间点到(T-1)秒这段时间 里，定时器都不需要做任何事情。当 T 秒时间过去之后，定时器取优先级队列中队首的任务执行。然后再计算新的队首任务 的执行时间点与当前时间点的差值，把这个值作为定时器执行下一个任务需要等待的时间。这样，定时器既不用间隔 1 秒就轮询一次，也不用遍历整个任务列表，性能也就提高了。

- TOPK问题
  - 静态TOPK:
  - 动态TOPK：比如我们求前k大数据，我们可以维护大小为K的小顶堆。
- 求动态数据中的中位数

维护两个堆即可，大顶堆存较小的数，小顶堆存较大的数。

![image-20201105164938563](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105164939.png)

进而，我们可以求出接口99%的响应时间，同理，当前的数据为1000个，则大顶堆中保存990个数据，小顶堆保存10个数据。则大顶堆堆顶的数据即为所求。

# 16. 图

常见题型：图的搜索、最短路径、最小生成树、二分图。

图的存储：**邻接矩阵**(Adjacency Matrix)，但是比较浪费存储空间，**稀疏图**(Sparse Matrix)更加浪费存储空间。优点是简单，方便计算，用邻接矩阵的方式存储图，可以将很多图的运算 转换成矩阵之间的运算。比如求解最短路径问题时会提到一个Floyd-Warshall 算法，就是 利用矩阵循环相乘若干次得到结果。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201102225356.png" alt="image-20201102225356287" style="zoom:50%;" />

**邻接表(Adjacency List)**：

![image-20201102231258354](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201102231258.png)

## BFS

广度优先搜索(Breadth-First-Search)。最坏情况下，终止顶点 t 离起始顶点 s 很远，需要遍历完整个图才能找到。这个时候，每 个顶点都要进出一遍队列，每个边也都会被访问一次，所以，广度优先搜索的时间复杂度是 **O(V+E)**，其中，V 表示顶点的个数，E 表示边的个数。当然，对于一个连通图来说，也就 是说一个图中的所有顶点都是连通的，E 肯定要大于等于 V-1，所以，广度优先搜索的时间 复杂度也可以简写为 O(E)。广度优先搜索的空间消耗主要在几个辅助变量 visited 数组、queue 队列、prev 数组上。 这三个存储空间的大小都不会超过顶点的个数，所以空间复杂度是 **O(V)**。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201102234132.png" alt="image-20201102234132362" style="zoom:50%;" />

```java
package com.code.leetcode.graph;
public class Graph {
    /**
     * 顶点的个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次 adj[s].add(t)
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[t].add(s);
    }

    /**
     * @param s 起点
     * @param t 终点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // visited是用来记录已经被访问的顶点，用来避免顶点被重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // queue用来存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev用来记录搜索路径,prev[w]存储的是，顶点w是从哪个前驱顶点遍历过来的
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 递归打印 s->t 的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
```

中间过程：

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201103093901.png" alt="image-20201103093901610" style="zoom:33%;" />

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201103093918.png" alt="image-20201103093917992" style="zoom:33%;" />

## DFS

每条边最多会被访问两次，一次是遍历，一次是回退。所以，图上的深度优先搜索算法的**时间复杂度是 O(E)**，E 表示边的个数。

深度优先搜索算法的消耗内存主要是 visited、prev 数组和递归调用栈。visited、prev 数组的大小跟顶点的个数 V 成正比，递归调用栈的最大深度不会超过顶点的个数，所以总的**空间复杂度就是 O(V)**。

```java
boolean found = false;

public void dfs(int s, int t) {
  boolean[] visited = new boolean[v];
  int[] prev = new int[v];
  Arrays.fill(prev, -1);
  recurDfs(s, t, visited, prev);
  print(prev, s, t);
}

private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
  if (found == true) {
    return;
  }
  visited[w] = true;
  if (w == t) {
    found = true;
    return;
  }
  for (int i = 0; i < adj[w].size(); ++i) {
    int q = adj[w].get(i);
    if (!visited[q]) {
      prev[q] = w;
      recurDfs(q, t, visited, prev);
    }
  }
}
```

![image-20201103103745072](https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201103103745.png)

# 17. 字符串匹配算法

## 单模式串匹配算法

单模式传匹配算法，即一个串跟一个串进行匹配。

### BF

 Brute Force，暴力匹配，朴素匹配。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201106161648.png" alt="image-20201106161615965" style="zoom:33%;" />

### RK

### BM

这玩意这太难了。

### KMP

## 多模式串匹配算法

### Trie树

Trie 树，也叫“字典树”。是一种专门处理字符串匹配的数据结构，用来解决在一组字符串集合中快速查找某个字符串的问题。

**Trie 树的本质，就是利用字符串之间的公共前缀， 将重复的前缀合并在一起**。

使用场景：搜索引擎的自动提示，IDEA的自动补全，

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201106174219.png" alt="image-20201106174218574" style="zoom:33%;" />

举个例子：我们有6个字符串，how，hi，her， hello，so，see，我们需要多次查找某个字符串是否存在？

我们可以对这6个字符串做预处理，构成Trie树：

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201106174510.png" alt="image-20201106174510070" style="zoom:50%;" />

下面我们看如何实现一颗Trie树，操作分为：将字符串插入Trie树，在Trie树中查询一个字符串。

```java
package com.code.geekbang.trie;

/**
 * Trie树
 */
public class Trie {
    /**
     * 存储无意义字符
     */
    private TrieNode root = new TrieNode('/');

    /**
     * 插入字符串
     * 时间复杂度是O(n)，n为所有字符串长度的和
     *
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在 Trie 树中查找一个字符串
     * 时间复杂度为O(k)，k为待查找字符串的长度，可以看到跟原本那组字符串的长度和个数没有任何关系
     *
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                // 不存在 pattern
                return false;
            }
            p = p.children[index];
        }
        // 不能完全匹配，只是前缀
        if (p.isEndingChar == false) {
            return false;
            // 找到 pattern
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("how".toCharArray());
        trie.insert("hi".toCharArray());
        trie.insert("her".toCharArray());
        trie.insert("hello".toCharArray());
        trie.insert("so".toCharArray());
        trie.insert("see".toCharArray());
        System.out.println(trie.find("how".toCharArray()));
        System.out.println(trie.find("ho".toCharArray()));
    }

    /**
     * 假设我们的字符串中只有从a到z这26个小写字母
     */
    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isEndingChar = false;

        TrieNode(char data) {
            this.data = data;
        }
    }
}
```

Trie树的局限性：

- 字符串中包含的字符集不能太大；
- 要求字符串的前缀重合比较多，不然空间消耗会变大很多；
- 需要手动实现Trie树；
- 对缓存不友好，因为通过指针串起来的数据块是不连续的；

其适合的场景是查找前缀匹配的字符串。

### AC自动机

场景:在很多网站中，我们需要对敏感词进行过滤。

TODO



# 18. 基础算法思想

下面是几种比较常见的算法思想。

## 贪心算法

应用场景：霍夫曼编码(Huffman Coding)、Prim 和 Kruskal 最小生成树算法、还有 Dijkstra 单源最短路径算法。

贪心算法(greedy algorithm)。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201107103849.png" alt="image-20201107103848050" style="zoom:50%;" />

哈夫曼编码具体case：

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201107103330.png" alt="image-20201107103329909" style="zoom:50%;" />

我们把每个字符看作一个节点，并且辅带着把频率放到优先级队列中。我们从队列中取出频 率最小的两个节点 A、B，然后新建一个节点 C，把频率设置为两个节点的频率之和，并把 这个新节点 C 作为节点 A、B 的父节点。最后再把 C 节点放入到优先级队列中。重复这个 过程，直到队列中没有数据。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201107103430.png" alt="image-20201107103429798" style="zoom:50%;" />

现在，我们给每一条边加上画一个权值，指向左子节点的边我们统统标记为 0，指向右子节 点的边，我们统统标记为 1，那从根节点到叶节点的路径就是叶节点对应字符的霍夫曼编码。

![image-20201107103555679](../../../Library/Application Support/typora-user-images/image-20201107103555679.png)

课后练习：

1. 在一个非负整数 a 中，我们希望从中移除 k 个数字，让剩下的数字值最小，如何选择移 除哪 k 个数字呢?

2. 假设有 n 个人等待被服务，但是服务窗口只有一个，每个人需要被服务的时间长度是不 同的，如何安排被服务的先后顺序，才能让这 n 个人总的等待时间最短?

## 分治算法



## 回溯算法

> 如数独、八皇后、0-1 背包、图 的着色、旅行商问题、全排列。

# mysql的索引

使用mysql来查询数据，我们比较关注的两个点是等值查询和范围查询，如：

```
select * from user where id=1234;
select * from user where id > 1234 and id < 2345
```

我们前面学到的数据结构中：

- 散列表：等值查询时间复杂度为O(1)，但可能存在hash冲突的问题，且范围查询不支持；
- 二分查找树：可能失衡
- 平衡二叉树（AVL，红黑树）：范围查询仍然不方便，且树的高度为logn；
- 跳表：插入、查找、删除数据的时间复杂度都为logn,同时支持区间查询，但是logn的时间复杂度仍然过高。且B+树提出于1972年，跳表提出于1989年，所以B+树才是爸爸。

综上，我们必须要降低树的高度，所以肯定是多叉树。

- B树：

![image-20201105202110991](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105202229.png)

- B+树

![image-20201105202321880](https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105202322.png)

我们来对比下B树和B+树：

|          | B              | B+                                                         |
| -------- | -------------- | ---------------------------------------------------------- |
| 存储结构 | 每个节点存数据 | 叶子节点存数据，非叶子节点存储索引。所以可以存放更多的数据 |
| 查找性能 | 不稳定         | 稳定，必须查找到叶子节点                                   |
| 范围查询 | 不支持         | 支持                                                       |

所以，mysql的索引选择了B+树。那么B+树是怎么演化来的呢？

如果我们对二分查找树进行改造，树中的节点并不存储数据本身，而是只是作为索引。除此之外，我们把每个叶子节点串在一条链表上，链表中的数据是从小到大有序的。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105202855.png" alt="image-20201105202855245" style="zoom:50%;" />

如果我们要为上亿的数据建立索引，比如，我们给一亿个数据构建二叉查找树索引，那索引中会包含大约 1 亿个节点，每个节 点假设占用 16 个字节，那就需要大约 1GB 的内存空间。给一张表建立索引，我们需要 1GB 的内存空间。如果我们要给 10 张表建立索引，那对内存的需求是无法满足的。如何解决这个索引占用太多内存的问题呢?

答案是把索引存放到硬盘中，但是如此一来，需要从硬盘中读取数据，速度是无法忍受的，因为树高是需要IO的次数，所以要降低树高。答案是多叉树。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105211756.png" alt="image-20201105211756394" style="zoom:33%;" />

那多叉树的m到底是多少比较好呢？不管是内存中的数据，还是磁盘中的数据，操作系统都是按页(一页大小通常是 4KB，这 个值可以通过 getconfig PAGE_SIZE 命令查看)来读取的，一次会读一页的数据。如果要 读取的数据量超过一页的大小，就会触发多次 IO 操作。所以，我们在选择 m 大小的时 候，要尽量让每个节点的大小等于一个页的大小。读取一个节点，只需要一次磁盘 IO 操作。

<img src="https://cdn.jsdelivr.net/gh/haojunsheng/ImageHost/img/20201105212230.png" alt="image-20201105212230406" style="zoom:50%;" />



# 海量数据问题

1. 多文件合并

问：现在你有 10 个接口访问日志文件，每个日志文件大小约 300MB，每个文件里的日志都是 按照时间戳从小到大排序的。你希望将这 10 个较小的日志文件，合并为 1 个日志文件，合 并之后的日志仍然按照时间戳从小到大排列。如果处理上述排序任务的机器内存只有 1GB，你有什么好的解决思路，能“快速”地将这 10 个日志文件合并吗?

答：IO多路归并。

2. 10 万条 URL 访问日志，如何按照访问次数给 URL 排序
3. 有两个字符串数组，每个数组大约有 10 万条字符串，如何快速找出两个数组中相同的字符串?



# 参考

[github源码](https://github.com/wangzheng0822/algo)

