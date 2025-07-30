package back2basics.concurrencytest.domain.coffee.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeStockRepository extends JpaRepository<CoffeeStock, Long> {
    CoffeeStock findAvailableStock();
}