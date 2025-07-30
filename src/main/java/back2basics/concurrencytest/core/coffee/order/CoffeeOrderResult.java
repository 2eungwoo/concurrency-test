package back2basics.concurrencytest.core.coffee.order;

import back2basics.concurrencytest.domain.coffee.reward.CoffeeReward;

public record CoffeeOrderResult(Long orderId, CoffeeReward reward, int rank) {
    public static CoffeeOrderResult of(Long orderId, CoffeeReward reward, int rank) {
        return new CoffeeOrderResult(orderId, reward, rank);
    }
}
