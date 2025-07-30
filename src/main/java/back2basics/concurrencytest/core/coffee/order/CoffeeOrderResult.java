package back2basics.concurrencytest.core.coffee.order;

import back2basics.concurrencytest.domain.coffee.reward.CoffeeReward;

public record CoffeeOrderResult(Long orderId, CoffeeReward reward) {
    public static CoffeeOrderResult of(Long orderId, CoffeeReward reward) {
        return new CoffeeOrderResult(orderId, reward);
    }
}
