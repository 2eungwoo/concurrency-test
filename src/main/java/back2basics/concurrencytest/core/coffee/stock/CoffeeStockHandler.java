package back2basics.concurrencytest.core.coffee.stock;

import back2basics.concurrencytest.core.coffee.order.utils.SleepTimer;
import back2basics.concurrencytest.domain.coffee.stock.CoffeeStock;
import back2basics.concurrencytest.domain.coffee.stock.CoffeeStockQueryDslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoffeeStockHandler {

    private final CoffeeStockQueryDslRepository stockRepository;
    private final SleepTimer sleepTimer;

    public void decrease() {
        CoffeeStock stock = stockRepository.findAvailableStock();
        sleepTimer.sleep(); // 재고 감소 후 커밋 전 race condition 유도
        stock.decrease();
    }

}