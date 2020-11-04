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



# 9. 跳表

# 10. 散列表

# 11. hash算法

# 12. 二叉树

# 13. 红黑树

# 14. 递归树

# 15. 堆排序

# 16. 图

常见题型：图的搜索、最短路径、最小生成树、二分图。

图的存储：**邻接矩阵**(Adjacency Matrix)，但是比较浪费存储空间，**稀疏图**(Sparse Matrix)更加浪费存储空间。优点是简单，方便计算，用邻接矩阵的方式存储图，可以将很多图的运算 转换成矩阵之间的运算。比如求解最短路径问题时会提到一个Floyd-Warshall 算法，就是 利用矩阵循环相乘若干次得到结果。

<img src="https://raw.githubusercontent.com/haojunsheng/ImageHost/master/img/20201102225356.png" alt="image-20201102225356287" style="zoom:50%;" />

邻接表(Adjacency List)：

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

# 回溯算法

> 如数独、八皇后、0-1 背包、图 的着色、旅行商问题、全排列。



# 参考

[github源码](https://github.com/wangzheng0822/algo)

