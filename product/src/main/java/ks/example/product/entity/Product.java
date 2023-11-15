package ks.example.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ks.example.product.entity.attribute.ProductAttributeValue;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String shortDescription;

    private String description;

    private String specification;

    private String sku;

    private String gtin;

    private String slug;

    private Double price;

    private boolean hasOptions;

    private boolean isAllowedToOrder;

    private boolean isPublished;

    private boolean isFeatured;

    private boolean isVisibleIndividually;

    private boolean stockTrackingEnabled;

    private Long stockQuantity;

    private Long taxClassId;

    private String metaTitle;

    private String metaKeyword;

    private String metaDescription;

    private Long thumbnailMediaId;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST})
    @Builder.Default
    private List<ProductCategory> productCategories = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductAttributeValue> attributeValues= new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST})
    @Builder.Default
    private List<ProductImage> productImages = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Product parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    @JsonIgnore
    @Builder.Default
    private List<Product>products= new ArrayList<>();

    @OneToMany
    @JsonIgnore
    @Builder.Default
    List<ProductRelated> relatedProducts = new ArrayList<>();

    private boolean taxIncluded;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return hasOptions == product.hasOptions && isAllowedToOrder == product.isAllowedToOrder && isPublished == product.isPublished && isFeatured == product.isFeatured && isVisibleIndividually == product.isVisibleIndividually && stockTrackingEnabled == product.stockTrackingEnabled && taxIncluded == product.taxIncluded && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(shortDescription, product.shortDescription) && Objects.equals(description, product.description) && Objects.equals(specification, product.specification) && Objects.equals(sku, product.sku) && Objects.equals(gtin, product.gtin) && Objects.equals(slug, product.slug) && Objects.equals(price, product.price) && Objects.equals(stockQuantity, product.stockQuantity) && Objects.equals(taxClassId, product.taxClassId) && Objects.equals(metaTitle, product.metaTitle) && Objects.equals(metaKeyword, product.metaKeyword) && Objects.equals(metaDescription, product.metaDescription) && Objects.equals(thumbnailMediaId, product.thumbnailMediaId) && Objects.equals(brand, product.brand) && Objects.equals(productCategories, product.productCategories) && Objects.equals(attributeValues, product.attributeValues) && Objects.equals(productImages, product.productImages) && Objects.equals(parent, product.parent) && Objects.equals(products, product.products) && Objects.equals(relatedProducts, product.relatedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortDescription, description, specification, sku, gtin, slug, price, hasOptions, isAllowedToOrder, isPublished, isFeatured, isVisibleIndividually, stockTrackingEnabled, stockQuantity, taxClassId, metaTitle, metaKeyword, metaDescription, thumbnailMediaId, brand, productCategories, attributeValues, productImages, parent, products, relatedProducts, taxIncluded);
    }
}
