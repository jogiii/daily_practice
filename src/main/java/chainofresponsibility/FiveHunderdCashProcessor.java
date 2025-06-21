package chainofresponsibility;

public class FiveHunderdCashProcessor extends CashProcessor{

    public FiveHunderdCashProcessor(CashProcessor next) {
        super(next);
    }

    @Override
    public void withdraw(int amount) {
        int note = 500;
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
