package trieTree;

import tree.Node;

/**
 * 前缀树
 */
public class TrieTree {

    private TrieNode root;

    public TrieTree(TrieNode root) {
        this.root = root;
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        for (char c :chars){
            // 对应走哪条路
            int index = c - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    // word在前缀树中出现了几次
    public int search(String word) {
        if (word == null) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            int index = c - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public int prefixNumber(String word) {
        if (word == null) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            int index = c - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public void delete(String word) {
        if (search(word) == 0) {
            return;
        }
        TrieNode node = root;
        node.pass--;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (--node.nexts[index].pass == 0) {
                node.nexts[index] = null;
            }
            node = node.nexts[index];
        }
        node.end--;

    }

    public static class TrieNode {
        // 节点通过几次
        public int pass;
        // 是几个字符串的重点
        public int end;
        // 如果不止26个字符，可以换成hashMap
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            // next[0] 代表有没有走向a的路
            this.nexts = new TrieNode[26];
        }
    }
}
