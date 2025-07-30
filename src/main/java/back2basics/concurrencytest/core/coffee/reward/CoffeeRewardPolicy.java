package back2basics.concurrencytest.core.coffee.reward;

import back2basics.concurrencytest.domain.coffee.reward.CoffeeReward;

public interface CoffeeRewardPolicy {
    CoffeeReward assignReward(int rank);
}