package com.issoft.csv;

import com.issoft.exception.BusinessException;
import com.issoft.model.OrderItem;
import com.issoft.model.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemReaderWriter {

    private static final String FILE_NAME_IMPORT = "order_items.csv";
    private static final String SEPARATOR = ",";

    public static List<OrderItem> readItems() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File((FILE_NAME_IMPORT))))) {
            List<OrderItem> orderItems = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                orderItems.add(OrderItemConverter.parseItem(line, SEPARATOR));
            }
            return orderItems;
        } catch (IOException ex) {
            throw new BusinessException("Could not read products", ex);
        }
    }
}
