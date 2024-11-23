package kiso2a.lesson2;

public class Test02A {
    public static void main(String[] args)
    {
        Stack s = new Stack();
        for (int i = 1; i <= 10; i++)
        {
            s.push(i);  //1,2,...,10 の順にスタックに整数をpush
        }
        while (!s.isEmpty())
        {
            int n = s.pop();
            System.out.println(n);
        }

        Queue q = new Queue();
        for (int i = 1; i <= 10; i++)
        {
            q.enqueue(i);   //1,2,...,10 の順にキューに整数を追加
        }
        while(!q.isEmpty())
        {
            int n = q.dequeue();
            System.out.println(n);
        }
    }
}
