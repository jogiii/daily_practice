package chainofresponsibility;

public abstract class CashProcessor {
    protected CashProcessor next;

    public CashProcessor(CashProcessor next){
        this.next = next;
    }

    public void withdraw(int amount){
        if(next != null){
            next.withdraw(amount);
        }else if(amount > 0){
            System.out.println("Cannot dispense remaining amount: ₹" + amount);
        }
    }

}
