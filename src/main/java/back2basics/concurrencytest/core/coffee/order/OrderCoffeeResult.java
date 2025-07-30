package back2basics.concurrencytest.core.coffee.order;

import back2basics.concurrencytest.domain.coffee.reward.CoffeeReward;

public record OrderCoffeeResult(Long orderId, CoffeeReward reward) {
    public static OrderCoffeeResult of(Long orderId, CoffeeReward reward) {
        return new OrderCoffeeResult(orderId, reward);
    }
}
