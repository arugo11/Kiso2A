package kiso2a.lesson2;

public class SampleClass01 {

    static int  i = 10;
    public static void main(String[] args)
    {
        add10();    System.out.println("i=" +i);
    }

    public static void add10()
    {
        i += 10;
    }
}
