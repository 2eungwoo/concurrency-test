package back2basics.concurrencytest.core.coffee.order;

import back2basics.concurrencytest.core.coffee.order.utils.OrderRankCalculator;
import back2basics.concurrencytest.core.coffee.reward.CoffeeRewardPolicy;
import back2basics.concurrencytest.core.coffee.stock.CoffeeStockHandler;
import back2basics.concurrencytest.domain.coffee.order.CoffeeOrder;
import back2basics.concurrencytest.domain.coffee.order.CoffeeOrderRepository;
import back2basics.concurrencytest.domain.coffee.reward.CoffeeReward;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CoffeeOrderService implements CoffeeOrderUseCase {

    private final CoffeeOrderRepository orderRepository;
    private final CoffeeStockHandler stockHandler;
    private final CoffeeRewardPolicy rewardPolicy;
    private final OrderRankCalculator rankCalculator;

    @Override
    @Transactional
    public CoffeeOrderResult order(CoffeeOrderCommand command) {
        // 1. 재고 차감
        stockHandler.decrease();

        // 2. 순위 계산 및 보상 결정
        int rank = rankCalculator.calculate();
        CoffeeReward reward = rewardPolicy.assignReward(rank);

        // 3. 주문 생성 및 저장
        CoffeeOrder order = CoffeeOrder.create(command.userId(), command.coffeeName(), reward);
        CoffeeOrder saved = orderRepository.save(order);

        // 4. 결과 반환
        return CoffeeOrderResult.of(saved.getId(), saved.getReward());
    }
}