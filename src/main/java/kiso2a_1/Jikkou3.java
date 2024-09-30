package kiso2a_1;



public class Jikkou3 {

    public static void main(String[] args)
    {
        Saifu2 mySaifu = new Saifu2();
        int max;
        if(args.length == 0)
        {
            max = 25;
        }
        else
        {
            max = Integer.parseInt(args[0]);
        }

        long okodukai = 10;
        for(int i = 1; i < max + 1; i++)
        {
            mySaifu.setOkane(mySaifu.getOkane() + okodukai);
            System.out.println(String.format("day=%d okane=%d", i,mySaifu.getOkane()));
            okodukai *= 2;
        }

    }
}
