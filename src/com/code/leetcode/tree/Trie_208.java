package com.code.leetcode.tree;

/**
 * 实现 Trie (字典树，前缀树,单词查找树)
 * 实现一个Trie (前缀树)，包含insert, search, 和startsWith这三个操作。
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * 性质：一次建树，多次查询
 * 1. Trie 的形状和单词的插入或删除顺序无关，也就是说对于任意给定的一组单词，Trie 的形状都是唯一的。
 * 2. 查找或插入一个长度为 L 的单词，访问 next 数组的次数最多为 L+1，和 Trie 中包含多少个单词无关。
 * 3. Trie 的每个结点中都保留着一个字母表，这是很耗费空间的。如果 Trie 的高度为 n，字母表的大小为 m，最坏的情况是 Trie 中还不存在前缀相同的单词，那空间复杂度就为 O(m^n)
 * @author 俊语
 * @date 2020/9/18 23:03
 */
public class Trie_208 {

    private TireNode root;

    public static void main(String[] args) {
        Trie_208 trie208 = new Trie_208();
        trie208.insert("apple");
        System.out.println(trie208.search("apple"));
        System.out.println(trie208.search("app"));
        System.out.println(trie208.startsWith("app"));
    }

    /**
     * Initialize your data structure here.
     */
    public Trie_208() {
        root = new TireNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TireNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    class TireNode {
        // 该结点是否是一个串的结束
        private boolean isEnd;
        // 字母映射表,保存了对当前结点而言下一个可能出现的所有字符的链接，因此我们可以通过一个父结点来预知它所有子结点的值
        TireNode[] next;

        public TireNode() {
            isEnd = false;
            next = new TireNode[26];
        }
    }
}
