package back2basics.concurrencytest.api;

import back2basics.concurrencytest.core.coffee.order.CoffeeOrderCommand;
import back2basics.concurrencytest.core.coffee.order.CoffeeOrderResult;
import back2basics.concurrencytest.core.coffee.order.CoffeeOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coffee/orders")
@RequiredArgsConstructor
public class CoffeeOrderController {

    private final CoffeeOrderUseCase orderUseCase;

    @PostMapping
    public ResponseEntity<CoffeeOrderResponse> order(@RequestBody CoffeeOrderRequest request) {
        CoffeeOrderCommand command = CoffeeOrderCommand.of(request.userId(), request.coffeeName());
        CoffeeOrderResult result = orderUseCase.order(command);
        return ResponseEntity.ok(CoffeeOrderResponse.from(result));
    }
}
