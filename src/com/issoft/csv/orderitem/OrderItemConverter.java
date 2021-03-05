package com.issoft.csv.orderitem;

import com.issoft.model.orderitem.OrderItem;

public class OrderItemConverter {

    public static OrderItem parseItem(String data, String separator) {
        String[] fields = data.split(separator);
        String orderID = fields[OrderItemFields.ORDER_ID.ordinal()];
        String productId = fields[OrderItemFields.PRODUCT_ID.ordinal()];
        Integer quantity = Integer.parseInt(fields[OrderItemFields.QUANTITY.ordinal()]);

        return new OrderItem(orderID, productId, quantity);
    }
}
