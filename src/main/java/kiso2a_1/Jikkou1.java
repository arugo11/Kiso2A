package kiso2a_1;

public class Jikkou1 {
    public static void main(String[] args)
    {
        Saifu mySaifu = new Saifu();
        mySaifu.getOkane();
        mySaifu.okane = mySaifu.getOkane();
        mySaifu.setOkane(mySaifu.okane + 5000);
        System.out.println("okane=" + mySaifu.getOkane());
    }
}
