public class Test03D {
    public static void main(String[] args)
    {
        MyList list = new MyList();
        for (int i = 1; i < 10; i++)
        {
            list.add(i*100);
        }

        MyList list2 = new MyList();
        for (int i = 1; i <= 10; i++)
        {
            list2.add(i * 111);
        }

        list.concat(list2);
        list.print();

        MyList list3 = list2;
        list2.concat(list3);
        list.print();
    }
}
