package com.issoft.csv;

import com.issoft.model.OrderItem;
import com.issoft.model.Product;

import java.math.BigDecimal;

public class OrderItemConverter {

    public static OrderItem parseItem(String data, String separator) {
        String[] fields = data.split(separator);
        Integer orderID = Integer.parseInt(fields[OrderItemFields.ORDER_ID.ordinal()]);
        Integer productId = Integer.parseInt(fields[OrderItemFields.PRODUCT_ID.ordinal()]);
        Integer quantity = Integer.parseInt(fields[OrderItemFields.QUANTITY.ordinal()]);

        return new OrderItem(orderID, productId, quantity);
    }
}
