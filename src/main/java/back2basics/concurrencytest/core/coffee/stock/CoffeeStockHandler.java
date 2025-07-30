package back2basics.concurrencytest.core.coffee.stock;

import back2basics.concurrencytest.domain.coffee.stock.CoffeeStock;
import back2basics.concurrencytest.domain.coffee.stock.CoffeeStockQueryDslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoffeeStockHandler {

    private final CoffeeStockQueryDslRepository stockRepository;

    public void decrease() {
        CoffeeStock stock = stockRepository.findAvailableStock();
        stock.decrease();
    }
}