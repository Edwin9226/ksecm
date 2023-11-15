package ks.example.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class Brand extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    private boolean isPublished;
    @OneToMany(mappedBy = "brand")
    List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand brand)) return false;
        return isPublished == brand.isPublished && Objects.equals(id, brand.id) && Objects.equals(name, brand.name) && Objects.equals(slug, brand.slug) && Objects.equals(products, brand.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug, isPublished, products);
    }


}
