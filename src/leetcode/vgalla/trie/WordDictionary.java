package leetcode.vgalla.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode1 {
    private char c;
    private Map <Character, TrieNode1> map = new HashMap <Character, TrieNode1> ();
    
    public TrieNode1(char c) {
        this.c = c;
    }
    
    public void addWord(String word) {
        if (word.length() > 0) {
            char c = word.charAt(0);
            TrieNode1 childNode;
            if (this.map.containsKey(c)) {
                childNode = this.map.get(c);
            } else {
                childNode = new TrieNode1(c);
                this.map.put(c, childNode);
            }
            childNode.addWord(word.substring(1));
        } else {
            this.map.put('$', null);
        }
    }
    
    public boolean search(String word) {
        if (word.length() > 0) {
            char c = word.charAt(0);
            if (c == '.') {
                boolean solution = false;
                for (Character c1: this.map.keySet()) {
                    if (!c1.equals('$')) {
                        solution = solution ||  this.map.get(c1).search(word.substring(1));    
                    }
                }
                return solution;
            } else {
                if (this.map.containsKey(c)) {
                    return this.map.get(c).search(word.substring(1));
                } else {
                    return false;
                }
            }
            
        } else {
            if (this.map.containsKey('$')) {
                return true;
            } else {
                return false;
            }
        }
    }
}

public class WordDictionary {

    private TrieNode1 root;
    
    public WordDictionary() {
        root = new TrieNode1('^');
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        this.root.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return this.root.search(word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");