package back2basics.concurrencytest.domain.coffee.reward;

public class CoffeeRewardPolicy {

    public static CoffeeReward getRewardByRank(int rank) {
        if (rank == 1) {
            return CoffeeReward.GOLD;
        } else if (rank == 2) {
            return CoffeeReward.SILVER;
        } else if (rank == 3) {
            return CoffeeReward.BRONZE;
        } else if (rank >= 4 && rank <= 10) {
            return CoffeeReward.WOOD;
        } else if (rank >= 11 && rank <= 100) {
            return CoffeeReward.NORMAL;
        } else {
            throw new IllegalArgumentException("늦었습니다. 오소이! : " + rank);
        }
    }
}
