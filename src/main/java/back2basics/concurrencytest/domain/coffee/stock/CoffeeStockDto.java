package back2basics.concurrencytest.domain.coffee.stock;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class CoffeeStockDto {

    private final Long id;
    private final int quantity;

    @QueryProjection
    public CoffeeStockDto(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
