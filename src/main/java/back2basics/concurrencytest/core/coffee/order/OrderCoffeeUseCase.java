package back2basics.concurrencytest.core.coffee.order;

public interface OrderCoffeeUseCase {
    OrderCoffeeResult order(OrderCoffeeCommand command);
}