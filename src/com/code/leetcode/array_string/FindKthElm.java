package com.code.leetcode.array_string;

/**
 * 给定两个有序的数组，求出所有的元素中，第k小的
 *
 * @author 俊语
 * @date 2020/9/19 23:50
 */
public class FindKthElm {
    public static void main(String[] args) {
        int[] arr1 = {1,3}, arr2 = {2};
        int k=2;
        FindKthElm findKthElm=new FindKthElm();
        System.out.println(findKthElm.findKthElm(arr1,arr2,k));
    }

    /**
     * 如果没有空间复杂度的要求，那么直接把两个数组合并，即可，这样的时间复杂度是O(m+n),空间复杂度是O(m+n)、
     * 此外，可以不用开辟数组，直接遍历，时间复杂度是O(m+n)
     * 注意，我们没有利用有序的特性，我们可以进行二分查找O(lg(m+n))
     * <p>
     * 找a和b两个有序数组中第K小，就是在a中找某个位置i，在b中找某个位置j，其满足条件为：
     * i+j=k,a[i-1]<=b[j]&&b[j-1]<=a[i],这样第K小即为：max(a[i-1],b[j-1]);
     * 在a数组中二分查找位置i，相应b中位置j=k-i,注意边界，0<=i<=n且k-m<=i<=k即max(0,k-m)<=i<=min(k,n);
     */
    private int findKthElm(int[] arr1, int[] arr2, int k) {
        return getKth(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1, k);
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        //就是如果len1长度小于len2，把getKth()中参数互换位置，即原来的len2就变成了len1，即len1，永远比len2小
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        //如果一个数组中没有了元素，那么即从剩余数组nums2的其实start2开始加k再-1.
        //因为k代表个数，而不是索引，那么从nums2后再找k个数，那个就是start2 + k-1索引处就行了。因为还包含nums2[start2]也是一个数。因为它在上次迭代时并没有被排除
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        //如果k=1，表明最接近中位数了，即两个数组中start索引处，谁的值小，中位数就是谁(start索引之前表示经过迭代已经被排出的不合格的元素，即数组没被抛弃的逻辑上的范围是nums[start]--->nums[end])。
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        //为了防止数组长度小于 k/2,每次比较都会从当前数组所生长度和k/2作比较，取其中的小的(如果取大的，数组就会越界)
        //然后素组如果len1小于k / 2，表示数组经过下一次遍历就会到末尾，然后后面就会在那个剩余的数组中寻找中位数
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        //如果nums1[i] > nums2[j]，表示nums2数组中包含j索引，之前的元素，逻辑上全部淘汰，即下次从J+1开始。
        //而k则变为k - (j - start2 + 1)，即减去逻辑上排出的元素的个数(要加1，因为索引相减，相对于实际排除的时要少一个的)
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}