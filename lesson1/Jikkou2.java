package kiso2a.lesson1;

public class Jikkou2 {
    public static void main(String[] args)
    {
        Saifu mySaifu = new Saifu();
        int okodukai = 10;
        for (int i = 1; i < 25 + 1; i++)
        {
            mySaifu.setOkane(mySaifu.getOkane() + okodukai);
            System.out.println(String.format("day=%d okane=%d", i,mySaifu.getOkane()));
            okodukai *= 2;
        }
        
        
    }
}
