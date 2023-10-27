class MyStack {
    Queue<Integer> que1;
     Queue<Integer> que2;
     int top;

    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
        
        
    }
    
    public void push(int x) {
        que1.offer(x);
        top=x;
        
    }
    
    public int pop() {
        while(que1.size()>1){
            top=que1.poll();
            que2.offer(top);
        }
        int val = que1.poll();
        while(!que2.isEmpty()){
            que1.offer(que2.poll());
        }
        return val;
        
    }
    
    public int top() {
        return top;
        
    }
    
    public boolean empty() {
        return que1.isEmpty();
    }
}
