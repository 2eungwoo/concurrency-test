package back2basics.concurrencytest.domain.coffee.reward;

import back2basics.concurrencytest.core.coffee.reward.CoffeeRewardPolicy;
import org.springframework.stereotype.Component;

@Component
public class CoffeeRewardPolicyImpl implements CoffeeRewardPolicy {

    @Override
    public CoffeeReward assignReward(int rank) {
        if (rank == 1) return CoffeeReward.GOLD;
        if (rank == 2) return CoffeeReward.SILVER;
        if (rank == 3) return CoffeeReward.BRONZE;
        if (rank <= 10) return CoffeeReward.WOOD;
        if (rank <= 100) return CoffeeReward.NORMAL;
        throw new IllegalArgumentException("늦었습니다. 오소이! : " + rank);
    }
}
