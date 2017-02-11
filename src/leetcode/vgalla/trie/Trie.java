package leetcode.vgalla.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // Initialize your data structure here.
    private char c;
    private Map <Character, TrieNode> map;
    public TrieNode() {
        map = new HashMap <Character, TrieNode> ();
    }
    
    public void setChar(char c) {
        this.c = c;
    }
    
    public void insert(String word) {
        if (word.length() > 0) {
            char c = word.charAt(0);
            TrieNode newNode = new TrieNode();
            newNode.setChar(c);
            this.map.put(c, newNode);
            newNode.insert(word.substring(1));
        } else {
            this.map.put('$', null);
        }
    }
    
    public boolean search(String word) {
    	if (word.length() == 0 || word == null) {
            if (this.map.containsKey('$')) {
                return true;
            } else {
                return false;
            }
        } else {
            char c = word.charAt(0);
            if (this.map.containsKey(c)) {
                return this.map.get(c).search(word.substring(1));
            } else {
                return false;
            }
        }
    }
    
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0 || prefix == null) {
            if (this.map.size() > 1) {
                return true;
            } else {
                return false;
            }
        } else {
            char c = prefix.charAt(0);
            if (this.map.containsKey(c)) {
                return this.map.get(c).startsWith(prefix.substring(1));
            } else {
                return false;
            }
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.setChar('^');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");