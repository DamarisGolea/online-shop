package org.fasttrackit.onlineshop.transfer.cart;

import org.fasttrackit.onlineshop.domain.Customer;

import javax.validation.constraints.NotNull;

public class AddProductToCartRequest {
    @NotNull
    private long customerId;
    @NotNull
    private long productId;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "AddProductToCartRequest{" +
                "customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
