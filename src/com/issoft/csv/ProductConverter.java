package com.issoft.csv;

import com.issoft.model.Product;

import java.math.BigDecimal;

public class ProductConverter {

    public static Product parseProduct(final String data, final String separator) {
        String[] fields = data.split(separator);
        Integer id = Integer.parseInt(fields[ProductFields.ID.ordinal()]);
        String name = fields[ProductFields.NAME.ordinal()];
        BigDecimal price = new BigDecimal(fields[ProductFields.PRICE.ordinal()]);

        return new Product(id, name, price);
    }
}
