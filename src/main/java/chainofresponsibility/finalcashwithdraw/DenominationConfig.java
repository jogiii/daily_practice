package chainofresponsibility.finalcashwithdraw;

import java.util.Arrays;
import java.util.List;

public class DenominationConfig {

    private List<Integer> denominations;

    public List<Integer> getDenominations() {
        return Arrays.asList(2000, 500, 100, 50, 20, 10, 5, 2, 1);
    }

    public void setDenominations(List<Integer> denominations) {
        this.denominations = denominations;
    }

}
