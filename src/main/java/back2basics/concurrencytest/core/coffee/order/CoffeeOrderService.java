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
    @Transactional(isolation = Isolation.DEFAULT)
    public CoffeeOrderResult orderWithDefault(CoffeeOrderCommand command) {
        return processOrder(command);
    }

    @Override
    public CoffeeOrderResult orderWithPessimisticLock(CoffeeOrderCommand command) {
        return null;
    }

    private CoffeeOrderResult processOrder(CoffeeOrderCommand command) {

        // 재고 감소 후 슬립: 다른 트랜잭션이 감소 전 재고값 참조 가능하게끔
        stockHandler.decrease();

        // 순위 계산 후 슬립: 다른 트랜잭션이 같은 순위를 할당받을 가능하게끔
        int rank = rankCalculator.calculate();

        CoffeeReward reward = rewardPolicy.assignReward(rank);

        CoffeeOrder order = CoffeeOrder.create(command.userId(), command.coffeeName(), reward, rank);
        CoffeeOrder saved = orderRepository.save(order);

        return CoffeeOrderResult.of(saved.getId(), saved.getReward(), rank);
    }
}