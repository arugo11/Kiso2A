public class BankAccount extends Chokin{
    String bank = "TokyoBank";

    BankAccount(String bank)
    {
        this.bank = bank;
    }

    @Override
    void print()
    {
        System.out.println(bank + okane + "yen");
    }
}
