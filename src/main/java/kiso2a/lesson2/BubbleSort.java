package kiso2a.lesson2;

public class BubbleSort {
    public static void main(String[] args)
    {
        String[] a = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
        sort(a);
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
    static void sort(String a[])
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a.length; j++)
            {
                String temp;
                if(a[i].compareTo(a[j]) < 0)
                {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}
