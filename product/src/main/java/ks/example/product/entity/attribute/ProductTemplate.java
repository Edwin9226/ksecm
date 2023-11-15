package ks.example.product.entity.attribute;

import jakarta.persistence.*;
import ks.example.product.entity.AbstractAuditEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product_template")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductTemplate extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productTemplate", cascade = {CascadeType.PERSIST})
    @Builder.Default
    private List<ProductAttributeTemplate> productAttributeTemplates= new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTemplate that = (ProductTemplate) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(productAttributeTemplates, that.productAttributeTemplates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productAttributeTemplates);
    }
}
