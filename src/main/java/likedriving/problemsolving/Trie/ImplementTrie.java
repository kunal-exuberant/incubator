package likedriving.problemsolving.Trie;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/*
* Incorrect impl of Trie
 */
public class ImplementTrie {

    class TrieNode{
        List<TrieNode> child = new ArrayList<>();
        char alphabet;
        boolean isLeaf = true;
        TrieNode(char alphabet){
            this.alphabet = alphabet;
        }
    }

    @Test
    public void test(){
        TrieNode trieNode = new TrieNode('t');

        trieNode.isLeaf = false;
        trieNode.child.add(new TrieNode( 'o'));
        trieNode.child.add(new TrieNode('p'));

        trieNode.child.get(0).isLeaf = false;
        trieNode.child.get(0).child.add(new TrieNode('m'));

        trieNode.child.get(1).isLeaf = false;
        trieNode.child.get(1).child.add(new TrieNode('n'));

        TrieNode root = trieNode;
        traverse(root);
    }

    private void traverse(TrieNode root){
        TrieNode temp = root;
        //  while (temp != null){
        System.out.println(temp.alphabet);
        if(!temp.isLeaf) {
            for (TrieNode childTemp : temp.child) {
                traverse(childTemp);
                //System.out.println(childTemp.alphabet);
                //temp = childTemp.child;
            }
        }
        else {
            System.out.println("----------");
        }
    }



}

