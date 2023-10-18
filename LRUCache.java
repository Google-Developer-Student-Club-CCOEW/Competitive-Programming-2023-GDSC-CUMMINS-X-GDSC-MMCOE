class Node{
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache
{
    static int capacity;
    static HashMap<Integer,Node> mp;
    static Node head;
    static Node tail;
    
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        this.capacity=cap;
        mp=new HashMap<>();
        head=null;
        tail=null;
    }
    
    static void shiftForward(Node node){
        remove(node);
        addForward(node);
    }
  
    static void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        
        if(prev!=null){
            prev.next=next;
        }else{
            head=next;
        }
        
        if(next!=null){
            next.prev=prev;
        }else{
            tail=prev;
        }
        
    }
  
    static void addForward(Node node){
        node.prev=null;
        node.next=head;
        
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(tail==null){
            tail=node;
        }
    }
    
    
    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            shiftForward(node);
            return node.value;
        }
        return -1;
        
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        // your code here
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            node.value=value;
            shiftForward(node);
            return;
        }
        Node temp=new Node(key,value);
        
        if(mp.size()==capacity){
            mp.remove(tail.key);
            remove(tail);
        }
        addForward(temp);
        mp.put(key,temp);
    }
    
}
