package com.code.geekbang.trie_35;

/**
 * Trie树
 *
 * @author 俊语
 * @date 2020/11/6 17:57
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
