package chainofresponsibility.finalcashwithdraw;

public class GenericCashProcessor extends CashProcessor {
    private final int denomination;

    public GenericCashProcessor(int denomination) {
        this.denomination = denomination;
    }

    @Override
    public void withdraw(int amount) {
        if (amount >= denomination) {
            int count = amount / denomination;
            int remainder = amount % denomination;
            System.out.println("Dispensing " + count + " x ₹" + denomination);
            super.withdraw(remainder);
        } else {
            super.withdraw(amount);
        }
    }
}

