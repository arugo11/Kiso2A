public class Test03C {
    public static void main(String[] args){
        MyList list = new MyList();
        for(int i = 1; i <= 10; i++)
        {
            list.add(i * 100);
        }
        list.print();

        System.out.println((list.indexOf(500)));
        System.out.println((list.indexOf(999)));

        System.out.println(list.get(5));
        System.out.println(list.get(15));
    }
}   
