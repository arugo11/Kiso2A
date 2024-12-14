package kiso2a.lesson2;

public class Stack {
    int[] a = new int[100];
    int top = 0;

    public void push(int val)
    {
        a[top] = val;
        top++;
    }

    public int pop()
    {
        return a[--top];
    }

    public boolean isEmpty()
    {
    if (top == 0)   {return true;}
    else            {return false;}
    }
}
