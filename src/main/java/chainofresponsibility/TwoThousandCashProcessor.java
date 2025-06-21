package chainofresponsibility;

public class TwoThousandCashProcessor extends CashProcessor{

    public TwoThousandCashProcessor(CashProcessor next) {
        super(next);
       
    }

    @Override
    public void withdraw(int amount) {
        int note = 2000;
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
