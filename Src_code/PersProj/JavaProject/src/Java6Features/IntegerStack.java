package Java6Features;


import java.util.ArrayDeque;
import java.util.Deque;

public class IntegerStack {

    // a stack implemented using Deque
    private Deque<Integer> data = new ArrayDeque<Integer>();

    // inserts an element into the head of the deque
    public void push(Integer element) {
        data.addFirst(element);
    }

    // pops the first element 
    public Integer pop() {
        return data.removeFirst();
    }

    // peeks the first element
    public Integer peek() {
        return data.peekFirst();
    }

    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();
        // push 5 elements
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println("After pushing 5 elements: " + stack);

        // pop 1 element 
        int m = stack.pop();
        System.out.println("Popped element = " + m);
        System.out.println("After popping 1 element  : " + stack);

        // peek 1 element 
        int n = stack.peek();
        System.out.println("Peeked element = " + n);
        System.out.println("After peeking 1 element : " + stack);
    }
}
