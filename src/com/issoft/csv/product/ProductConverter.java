package com.issoft.csv.product;

import com.issoft.model.product.Product;

import java.math.BigDecimal;

public class ProductConverter {

    public static Product parseProduct(final String data, final String separator) {
        String[] fields = data.split(separator);
        String id = fields[ProductFields.ID.ordinal()];
        String name = fields[ProductFields.NAME.ordinal()];
        BigDecimal price = new BigDecimal(fields[ProductFields.PRICE.ordinal()]);

        return new Product(id, name, price);
    }
}
