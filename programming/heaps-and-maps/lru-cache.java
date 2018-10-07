/*


https://www.interviewbit.com/problems/lru-cache/



LRU Cache
Asked in:  
Adobe
Citigroup
Amazon
Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor. 
Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 





*/




public class Solution {

    public class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> m;

    public Solution(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.m = new HashMap<Integer, ListNode>();
    }
    
    public void add(ListNode node) {
        ListNode prev = this.tail.prev;
        prev.next = node;
        this.tail.prev = node;
        node.prev = prev;
        node.next = this.tail;
    }
    
    public void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(m.containsKey(key)) {
            ListNode node = m.get(key);
            this.remove(node);
            this.add(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(m.containsKey(key)) {
            this.remove(m.get(key));
        }
        ListNode node = new ListNode(key, value);
        this.add(node);
        this.m.put(key, node);
        if(this.m.size() > this.capacity) {
            node = head.next;
            this.remove(node);
            this.m.remove(node.key);
        }
    }
}
