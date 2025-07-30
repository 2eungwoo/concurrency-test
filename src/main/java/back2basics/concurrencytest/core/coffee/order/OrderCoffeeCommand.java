package back2basics.concurrencytest.core.coffee.order;

public record OrderCoffeeCommand(Long userId, String coffeeName) {
    public static OrderCoffeeCommand of(Long userId, String coffeeName) {
        return new OrderCoffeeCommand(userId, coffeeName);
    }
}
