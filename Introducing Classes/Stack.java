//This class defines and integer stack that can hold 10 values 
public class Stack {
    int stack[] = new int[10];
    int tos; 

    //initialize top-of-stack
    Stack()
    {
        tos = -1; 
    }

    //push an item onto the stack 
    void push(int item)
    {
        if(tos==9)
            System.out.println("Stack is full.");
        else
            stack[++tos] = item;
    }

    //pop an item from the stack
    int pop()
    {
        if(tos<0)
        {
            System.out.println("Stack underflow.");
            return 0; 
        }
        else
            return stack[tos--];
    }
    
}
