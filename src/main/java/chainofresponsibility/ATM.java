package chainofresponsibility;

public class ATM {
    public static void main(String[] args) {
        CashProcessor cashProcessor = new TwoThousandCashProcessor(new FiveHunderdCashProcessor(new HunderdCashProcessor(null)));

        int amount = 3800;
        if (amount % 100 != 0) {
            System.out.println("Invalid amount. Must be multiple of 100");
        } else {
            cashProcessor.withdraw(amount);
        }
        
    }

}
