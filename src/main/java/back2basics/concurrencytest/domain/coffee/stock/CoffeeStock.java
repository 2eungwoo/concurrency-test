package back2basics.concurrencytest.domain.coffee.stock;

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
@Table(name = "coffee_stock")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoffeeStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coffee_name", nullable = false, unique = true)
    private String coffeeName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Builder(access = AccessLevel.PRIVATE)
    private CoffeeStock(String coffeeName, Integer quantity) {
        this.coffeeName = coffeeName;
        this.quantity = quantity;
    }

    public static CoffeeStock create(String coffeeName, Integer quantity) {
        return CoffeeStock.builder()
            .coffeeName(coffeeName)
            .quantity(quantity)
            .build();
    }
}