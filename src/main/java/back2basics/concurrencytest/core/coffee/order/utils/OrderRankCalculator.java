package back2basics.concurrencytest.core.coffee.order.utils;

import back2basics.concurrencytest.common.exception.EventClosedException;
import back2basics.concurrencytest.domain.coffee.order.CoffeeOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRankCalculator {
    private final CoffeeOrderRepository repository;

    public int calculate() {
        long count = repository.count();

        if (count >= 100) {
            throw new EventClosedException();
        }

        return (int) count + 1;
    }
}
