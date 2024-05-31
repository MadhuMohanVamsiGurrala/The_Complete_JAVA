import java.util.EmptyStackException;

class MyStack {
    private int[] stackArray;
    private int top; // Index of the top element

    // Initialize the stack
    public MyStack(int capacity) {
        stackArray = new int[capacity];
        top = -1;
    }

    // Push an item onto the stack
    public void push(int item) {
        if (top == stackArray.length - 1) {
            System.out.println("Stack is full. Cannot push " + item);
        } else {
            stackArray[++top] = item;
        }
    }

    // Pop an item from the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top--];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

public class TestStack {
    public static void main(String[] args) {
        MyStack stack1 = new MyStack(10);
        MyStack stack2 = new MyStack(10);

        // Push some numbers onto stack1
        for (int i = 0; i < 10; i++)
            stack1.push(i);

        // Push some numbers onto stack2
        for (int i = 10; i < 20; i++)
            stack2.push(i);

        // Pop and print stack1
        System.out.println("Stack in stack1:");
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }

        // Pop and print stack2
        System.out.println("Stack in stack2:");
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}
