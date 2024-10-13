package kiso2a.lesson2;

public class Queue 
{
    int[] a = new int[100];
    int head = 0;
    int tail = 0;

    void enqueue(int val)
    {
        tail++;
        a[tail] = val;
    }
    int dequeue()
    {
        head++;
        return a[head];
    }
    boolean isEmpty()
    {
        if (head == tail) return true;
        else              return false;
    }

}
