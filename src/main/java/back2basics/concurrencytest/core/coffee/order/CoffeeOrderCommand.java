package back2basics.concurrencytest.core.coffee.order;

public record CoffeeOrderCommand(Long userId, String coffeeName) {
    public static CoffeeOrderCommand of(Long userId, String coffeeName) {
        return new CoffeeOrderCommand(userId, coffeeName);
    }
}
