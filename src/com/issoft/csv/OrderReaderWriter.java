package com.issoft.csv;

import com.issoft.exception.BusinessException;
import com.issoft.model.Order;
import com.issoft.model.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderReaderWriter {

    private static final String FILE_NAME_IMPORT = "orders.csv";
    private static final String SEPARATOR = ",";

    public static List<Order> readOrders() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File((FILE_NAME_IMPORT))))) {
            List<Order> orders = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(OrderConverter.parseOrder(line, SEPARATOR));
            }
            return orders;
        } catch (IOException ex) {
            throw new BusinessException("Could not read orders", ex);
        }
    }
}
