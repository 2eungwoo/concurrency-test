package back2basics.concurrencytest.core.coffee.order;

import back2basics.concurrencytest.core.coffee.order.dto.CoffeeOrderCommand;
import back2basics.concurrencytest.core.coffee.order.dto.CoffeeOrderResult;
import back2basics.concurrencytest.core.coffee.order.usecase.CoffeeOrderUseCase;
import back2basics.concurrencytest.core.coffee.order.utils.OrderRankCalculator;
import back2basics.concurrencytest.core.coffee.reward.CoffeeRewardPolicy;
import back2basics.concurrencytest.core.coffee.stock.CoffeeStockHandler;
import back2basics.concurrencytest.domain.coffee.order.CoffeeOrder;
import back2basics.concurrencytest.domain.coffee.order.CoffeeOrderRepository;
import back2basics.concurrencytest.domain.coffee.reward.CoffeeReward;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CoffeeOrderService implements CoffeeOrderUseCase {

    private final CoffeeOrderRepository orderRepository;
    private final CoffeeStockHandler stockHandler;
    private final CoffeeRewardPolicy rewardPolicy;
    private final OrderRankCalculator rankCalculator;

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public CoffeeOrderResult orderWithReadUncommitted(CoffeeOrderCommand command) {
        return processOrder(command);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public CoffeeOrderResult orderWithReadCommitted(CoffeeOrderCommand command) {
        return processOrder(command);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public CoffeeOrderResult orderWithRepeatableRead(CoffeeOrderCommand command) {
        return processOrder(command);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public CoffeeOrderResult orderWithSerializable(CoffeeOrderCommand command) {
        return processOrder(command);
    }

    private CoffeeOrderResult processOrder(CoffeeOrderCommand command) {

        stockHandler.decrease();
        int rank = rankCalculator.calculate();

        CoffeeReward reward = rewardPolicy.assignReward(rank);

        CoffeeOrder order = CoffeeOrder.create(command.userId(), command.coffeeName(), reward, rank);
        CoffeeOrder saved = orderRepository.save(order);

        return CoffeeOrderResult.of(saved.getId(), saved.getReward(), rank);
    }

}