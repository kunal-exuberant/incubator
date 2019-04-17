package likedriving.problemsolving;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/*
*  An Implementation of Hash Map Basically and not hash table. It uses linked List to handle collision. A perfect implementation.
*  Does not handle the case of hash overload.
*/

public class HashTable<K, V> {
        int hashSize = 10;
        LinkedList<HashNode<K, V>> [] linkedList = new LinkedList[hashSize];


        public void put(K key, V value){

            HashNode hashNode = new HashNode(key, value);

            if(linkedList[getPosition(key)] == null){
                linkedList[getPosition(key)] = new LinkedList<>();
                linkedList[getPosition(key)].add(hashNode);
            }else{
                linkedList[getPosition(key)].add(hashNode);
            }
        }

        public V get(K key) throws ClassCastException{
            LinkedList linkedListEach =  linkedList[getPosition(key)];
            int index = 0;
            while(!((HashNode)linkedListEach.get(index)).key.equals(key)){
                index++;
            }
            return (V)((HashNode)linkedListEach.get(index)).value;
        }

        public void delete(K key){
            LinkedList linkedListEach =  linkedList[getPosition(key)];
            int index = 0;
            while(!((HashNode)linkedListEach.get(index)).key.equals(key)){
                index++;
            }
            linkedListEach.remove(index);
        }

        private int getPosition(K key){
            return key.toString().length() % hashSize;
        }

        @Test
        public void hashTableTest(){
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("kunal", "10");
            hashTable.put("mom", "3");
            hashTable.put("manoj","20");
            Assert.assertEquals(hashTable.get("kunal"), "10");
            Assert.assertEquals(hashTable.get("mom"), "3");
            hashTable.delete("mom");
            Assert.assertEquals(hashTable.get("manoj"), "20");
        }
}

class HashNode<K, V>{
    K key;
    V value;
    HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
