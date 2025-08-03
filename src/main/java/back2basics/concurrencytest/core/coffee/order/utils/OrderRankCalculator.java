package back2basics.concurrencytest.core.coffee.order.utils;

import back2basics.concurrencytest.common.exception.EventClosedException;
import back2basics.concurrencytest.domain.coffee.order.CoffeeOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRankCalculator {
    private final CoffeeOrderRepository repository;
    private final SleepTimer sleepTimer;

    public int calculate() {
        long count = repository.count();

        if (count >= 100) {
            throw new EventClosedException();
        }

        // 순위 계산 후 커밋 전 race condition 유도
        sleepTimer.sleep();
        return (int) count + 1;
    }
}
