package back2basics.concurrencytest.domain.coffee.stock;

import static back2basics.concurrencytest.domain.coffee.stock.QCoffeeStock.coffeeStock;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CoffeeStockQueryDslRepository {

    private final JPAQueryFactory queryFactory;

    public CoffeeStock findAvailableStock() {
        CoffeeStock stock = queryFactory
            .selectFrom(coffeeStock)
            .where(coffeeStock.quantity.gt(0))
            .orderBy(coffeeStock.id.asc())
            .fetchFirst();

        if (stock == null) {
            throw new IllegalStateException("재고 없음");
        }

        return stock;
    }
}
