package chainofresponsibility.finalcashwithdraw;

public class Main {

    public static void main(String[] args) {
        DenominationConfig denominationConfig = new DenominationConfig();
        var denominations = denominationConfig.getDenominations();


        CashProcessorChainBuilder builder = new CashProcessorChainBuilder(denominations);

        ATMService atmService = new ATMService(builder);
        int amount = 2234;
        System.out.println("Requested: rs"+amount);
        atmService.withdraw(amount);
    }

}
