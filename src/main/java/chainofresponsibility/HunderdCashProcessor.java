package chainofresponsibility;

public class HunderdCashProcessor extends CashProcessor{

    public HunderdCashProcessor(CashProcessor next) {
        super(next);
    }

    @Override
    public void withdraw(int amount) {
        int note = 100;
        if (amount >= note) {
            int count = amount / note;
            int remainder = amount % note;
            System.out.println("Dispensing " + count + " x ₹" + note);
            super.withdraw(remainder);
        } else {
            super.withdraw(amount);
        }
    }



}
