package back2basics.concurrencytest.api;

import back2basics.concurrencytest.core.coffee.order.CoffeeOrderResult;

public record CoffeeOrderResponse(Long orderId, String reward, int rank) {

    public static CoffeeOrderResponse from(CoffeeOrderResult result) {
        return new CoffeeOrderResponse(result.orderId(), result.reward().name(), result.rank());
    }
}
