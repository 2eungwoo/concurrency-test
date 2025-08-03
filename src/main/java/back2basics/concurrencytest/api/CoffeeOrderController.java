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

    @PostMapping("/read-uncommitted")
    public CoffeeOrderResult orderRU(@RequestBody CoffeeOrderCommand command) {
        return orderService.orderWithReadUncommitted(command);
    }

    @PostMapping("/read-committed")
    public CoffeeOrderResult orderRC(@RequestBody CoffeeOrderCommand command) {
        return orderService.orderWithReadCommitted(command);
    }

    @PostMapping("/repeatable-read")
    public CoffeeOrderResult orderRR(@RequestBody CoffeeOrderCommand command) {
        return orderService.orderWithRepeatableRead(command);
    }

    @PostMapping("/serializable")
    public CoffeeOrderResult orderS(@RequestBody CoffeeOrderCommand command) {
        return orderService.orderWithSerializable(command);
    }

}
