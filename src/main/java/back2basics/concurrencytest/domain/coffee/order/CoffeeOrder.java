package back2basics.concurrencytest.domain.coffee.order;

import back2basics.concurrencytest.domain.coffee.reward.CoffeeReward;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "coffee_orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "coffee_name", nullable = false)
    private String coffeeName;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "reward")
    @Enumerated(EnumType.STRING)
    private CoffeeReward reward;

    @Column(name = "order_rank", nullable = false)
    private int rank;

    @Builder(access = AccessLevel.PRIVATE)
    private CoffeeOrder(Long userId, String coffeeName, CoffeeReward reward, int rank) {
        this.userId = userId;
        this.coffeeName = coffeeName;
        this.createdAt = java.time.LocalDateTime.now();
        this.reward = reward;
        this.rank = rank;
    }

    public static CoffeeOrder create(Long userId, String coffeeName, CoffeeReward reward, int rank) {
        return CoffeeOrder.builder()
            .userId(userId)
            .coffeeName(coffeeName)
            .reward(reward)
            .rank(rank)
            .build();
    }
}