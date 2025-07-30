package back2basics.concurrencytest.core.coffee.order;

public interface CoffeeOrderUseCase {
    CoffeeOrderResult order(CoffeeOrderCommand command);
}