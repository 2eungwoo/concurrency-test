package back2basics.concurrencytest.domain.coffee.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private java.time.LocalDateTime createdAt;

    @Builder(access = AccessLevel.PRIVATE)
    private CoffeeOrder(Long userId, String coffeeName) {
        this.userId = userId;
        this.coffeeName = coffeeName;
        this.createdAt = java.time.LocalDateTime.now();
    }

    public static CoffeeOrder create(Long userId, String coffeeName) {
        return CoffeeOrder.builder()
            .userId(userId)
            .coffeeName(coffeeName)
            .build();
    }
}