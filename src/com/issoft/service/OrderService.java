package com.issoft.service;

import com.issoft.csv.orderitem.OrderItemReaderWriter;
import com.issoft.csv.order.OrderReaderWriter;
import com.issoft.csv.product.ProductReaderWriter;
import com.issoft.model.order.Order;
import com.issoft.model.orderitem.OrderItem;
import com.issoft.model.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    public Map<LocalDate, Product> calculate() {
        List<OrderItem> orderItems = OrderItemReaderWriter.readItems();
        Map<String, Order> orderMap = OrderReaderWriter.readOrders();
        Map<String, Product> productMap = ProductReaderWriter.readProducts();
        Map<LocalDate, Product> datePriceMap = new HashMap<>();
        for (OrderItem item : orderItems) {
            Order order = orderMap.get(item.getOrderId());
            Product product = productMap.get(item.getProductId());
            BigDecimal price = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            LocalDate orderDate = order.getDate();
            Product currentProduct = datePriceMap.get(orderDate);
            if (currentProduct == null || currentProduct.getPrice().compareTo(price) < 0) {
                datePriceMap.put(orderDate, product);
            }
        }
        return datePriceMap;
    }
}
