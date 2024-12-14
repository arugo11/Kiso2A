package kiso2a.lesson2;

public class Test02B {
    public static void main(String[] args)
    {
        Dog akita = new Dog();
        akita.setName(akita.getName() + "-KOU");
        System.out.println(akita.name.length());
        System.out.println(akita.name.toLowerCase());
        System.out.println(akita.name.replace("HA", "PO"));
        System.out.println((akita.name.split("-"))[0]);
    }
}
