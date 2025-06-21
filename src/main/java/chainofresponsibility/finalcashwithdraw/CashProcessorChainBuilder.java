package chainofresponsibility.finalcashwithdraw;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CashProcessorChainBuilder {

    private final List<Integer> config;

    public CashProcessorChainBuilder(List<Integer> config) {
        this.config = config;
    }

    public CashProcessor buildChain() {
        List<Integer> denominations = config.stream()
                .sorted(Comparator.reverseOrder()) // Ensure descending
                .collect(Collectors.toList());

        CashProcessor head = null;
        CashProcessor current = null;

        for (Integer denomination : denominations) {
            CashProcessor processor = new GenericCashProcessor(denomination);
            if (head == null) {
                head = processor;
            } else {
                current.setNext(processor);
            }
            current = processor;
        }

        return head;
    }
}

