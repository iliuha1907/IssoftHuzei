package com.issoft.csv.product;

import com.issoft.exception.BusinessException;
import com.issoft.model.product.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductReaderWriter {

    private static final String FILE_NAME_IMPORT = "products.csv";
    private static final String SEPARATOR = ",";

    public static Map<String, Product> readProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File((FILE_NAME_IMPORT))))) {
            reader.readLine();
            Map<String, Product> productMap = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("\"", "");
                Product product = ProductConverter.parseProduct(line, SEPARATOR);
                productMap.put(product.getId(), product);
            }
            return productMap;
        } catch (IOException ex) {
            throw new BusinessException("Could not read products", ex);
        }
    }
}
