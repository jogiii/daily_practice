package chainofresponsibility.finalcashwithdraw;


public class ATMService {

    private final CashProcessorChainBuilder builder;

    public ATMService(CashProcessorChainBuilder builder) {
        this.builder = builder;
    }

    public void withdraw(int amount) {
        CashProcessor processor = builder.buildChain();
        processor.withdraw(amount);
    }
}


