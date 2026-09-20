import java.util.HashMap;
class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    } 

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        removeNode(node);
        addNode(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            addNode(node);

            if(map.size() > capacity){
                Node lru = head.next;

                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }

    void addNode(Node node){
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */