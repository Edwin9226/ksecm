package ks.example.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "product_option_combination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOptionCombination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_option_id", nullable = false)
    private  ProductOption productOption;

    private int displayOrder;

    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOptionCombination that = (ProductOptionCombination) o;
        return displayOrder == that.displayOrder && Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(productOption, that.productOption) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, productOption, displayOrder, value);
    }
}
