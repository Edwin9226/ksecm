package ks.example.product.entity.attribute;

import jakarta.persistence.*;
import ks.example.product.entity.AbstractAuditEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "product_attribute_group")
@Getter
@Setter
public class ProductAttributeGroup extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAttributeGroup that = (ProductAttributeGroup) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
