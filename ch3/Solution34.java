package ch3;

import java.util.Stack;

public class Solution34 {
    
    // Stack current is actual storage stack
    // Stack buffer is a transitional stack that is only used when offer()
    // every time a item is offered, we pop all items in Stack current to Stack buffer,
    // and then push the item
    // and then pop all items in Stack buffer to Stack current
    // in this way, the latest added item is always at the top of Stack current

    static class MyQueue {
        
        private Stack<Integer> current;
        private Stack<Integer> buffer;
        
        public MyQueue() {
            current = new Stack<>();
            buffer = new Stack<>();
        }
        
        public void offer(int foo) {
            while (!current.isEmpty()) {
                buffer.push(current.pop());
            }
            
            buffer.push(foo);
            
            while (!buffer.isEmpty()) {
                current.push(buffer.pop());
            }
        }
        
        public int poll() {
            return current.pop();
        }

    }

    // Test Method Below

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        for (int i = 0; i <= 10; i++) {
            myQueue.offer(i);
            System.out.println("Enqueued " + i );
        }

        for (int i = 5; i >= 0; i--) {
            System.out.println(myQueue.poll() + " is dequeued");
        }
    }
}
