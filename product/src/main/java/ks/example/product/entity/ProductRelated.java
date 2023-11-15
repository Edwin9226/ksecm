package ks.example.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity(name = "product_related")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRelated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "related_product_id")
    private Product relatedProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRelated that = (ProductRelated) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(relatedProduct, that.relatedProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, relatedProduct);
    }
}
