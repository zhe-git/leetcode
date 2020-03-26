//TC:O(1)
//SC:O(capacity)

class LRUCache {
    
    class Node{
        int val;
        int key;
        Node prev;
        Node next;
        public Node(int k, int v){
            key = k;
            val = v;
        }
    }
    
    Map<Integer, Node> map;
    int size;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        map = new HashMap();
        this.capacity = capacity;
        head.next = tail;
        tail.next = head;
        size = 0;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }else{            
            remove(node);
            addHead(key, node.val);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            addHead(key, value);   
        }else{
            remove(node);
            addHead(key, value);
        }
    }
    
    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
        size--;
    }
    
    private void addHead(int key, int value){
        Node node = new Node(key, value);
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
        map.put(key, node);
        size++;
        if(size > capacity){
            Node preTail = tail.prev;
            remove(preTail);
        }
    }
}