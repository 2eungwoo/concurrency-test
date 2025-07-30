package back2basics.concurrencytest.core.coffee.stock;

import back2basics.concurrencytest.domain.coffee.stock.CoffeeStock;
import back2basics.concurrencytest.domain.coffee.stock.CoffeeStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoffeeStockHandler {

    private final CoffeeStockRepository stockRepository;

    public void decrease() {
        CoffeeStock stock = stockRepository.findAvailableStock()
            .orElseThrow(() -> new IllegalStateException("재고가 없습니다."));
        stock.decrease();
    }
}