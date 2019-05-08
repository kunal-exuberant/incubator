package likedriving.problemsolving.Trie;

import org.junit.Test;

public class ImplementTrie {

    class TrieNode{
        TrieNode [] child;
        char alphabet;
        boolean isLeaf = false;
    }

    @Test
    public void test(){
        TrieNode trieNode = new TrieNode();
        trieNode.alphabet = 't';
        trieNode.child[0] = new TrieNode();
        trieNode.child[0].alphabet = 'h';

/*        TrieNode temp = root;
        while (temp != null){
            System.out.println(temp.alphabet);
            for(TrieNode childTemp: temp.child) {
                temp = root.ch
            }
        }*/
    }



}

