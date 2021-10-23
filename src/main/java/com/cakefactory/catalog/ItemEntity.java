package com.cakefactory.catalog;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cvelasquez
 */
@Entity
@Table(name = "catalog")
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    String sku;

    String title;

    BigDecimal price;

    
    @Override
    public int hashCode() {
        return Objects.hashCode(sku);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItemEntity) {
            ItemEntity other = (ItemEntity) obj;
            return Objects.equals(this.sku, other.sku);
        }
        return false;
    }
}
