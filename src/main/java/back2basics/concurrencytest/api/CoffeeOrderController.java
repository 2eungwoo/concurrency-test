package back2basics.concurrencytest.api;

import back2basics.concurrencytest.core.coffee.order.dto.CoffeeOrderCommand;
import back2basics.concurrencytest.core.coffee.order.dto.CoffeeOrderResult;
import back2basics.concurrencytest.core.coffee.order.usecase.CoffeeOrderUseCase;
import back2basics.concurrencytest.global.ApiResponse;
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
    private final CoffeeOrderUseCase orderService;

    @PostMapping("/default")
    public CoffeeOrderResult orderD(@RequestBody CoffeeOrderCommand command) {
        return orderService.orderWithDefault(command);
    }

}
