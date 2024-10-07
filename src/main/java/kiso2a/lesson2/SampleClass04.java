package kiso2a.lesson2;

public class SampleClass04 {
    public static void main(String[] args)
    {
        Person taro = new Person("太郎");
        Person hanako = new Person();
        hanako.name = "花子";
        for (int i = 0; i < 100; i++)
        {
            taro.walk();
            hanako.walk();
            hanako.walk();
        }
        taro.print();
        hanako.print();

    }
}
