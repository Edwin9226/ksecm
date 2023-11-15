package ks.example.product.entity.attribute;

import jakarta.persistence.*;
import ks.example.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_attribute_value")
@Getter
@Setter
public class ProductAttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


}
