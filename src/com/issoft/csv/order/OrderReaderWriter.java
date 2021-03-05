package com.issoft.csv.order;

import com.issoft.exception.BusinessException;
import com.issoft.model.order.Order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrderReaderWriter {

    private static final String FILE_NAME_IMPORT = "orders.csv";
    private static final String SEPARATOR = ",";

    public static Map<String, Order> readOrders() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File((FILE_NAME_IMPORT))))) {
            reader.readLine();
            Map<String, Order> orderMap = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                Order order = OrderConverter.parseOrder(line, SEPARATOR);
                orderMap.put(order.getId(), order);
            }
            return orderMap;
        } catch (IOException ex) {
            throw new BusinessException("Could not read orders", ex);
        }
    }
}
