/* Implement a Queue using Java Stacks
 *
 * The Queue should be FIFO and have two methods: void enqueue(Integer i) and Integer dequeue()
 *
 * Examples:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.enqueue(1);
 * queue.enqueue(2);
 * queue.enqueue(3);
 *
 * queue.dequeue(); //1
 * queue.enqueue(4);
 * queue.dequeue(); //2
 * queue.dequeue(); //3
 * queue.dequeue(); //4
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 *
 */

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); //1
        queue.enqueue(4);
        System.out.println(queue.dequeue()); //2
        System.out.println(queue.dequeue()); //3
        System.out.println(queue.dequeue()); //4
    }

    TwoStackQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void enqueue(int num) {
        stack1.push(num);
    }

    public int dequeue(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
