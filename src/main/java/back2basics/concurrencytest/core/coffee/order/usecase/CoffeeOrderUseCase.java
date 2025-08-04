package back2basics.concurrencytest.core.coffee.order.usecase;

import back2basics.concurrencytest.core.coffee.order.dto.CoffeeOrderCommand;
import back2basics.concurrencytest.core.coffee.order.dto.CoffeeOrderResult;

public interface CoffeeOrderUseCase {
    CoffeeOrderResult orderWithDefault(CoffeeOrderCommand command);
}