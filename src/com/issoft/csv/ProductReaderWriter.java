package com.issoft.csv;

import com.issoft.exception.BusinessException;
import com.issoft.model.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductReaderWriter {

    private static final String FILE_NAME_IMPORT = "products.csv";
    private static final String SEPARATOR = ",";

    public static List<Product> readProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(
                ProductReaderWriter.class.getClassLoader().getResource(FILE_NAME_IMPORT).getFile())))) {
            List<Product> products = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(ProductConverter.parseProduct(line, SEPARATOR));
            }
            return products;
        } catch (IOException ex) {
            throw new BusinessException("Could not read products", ex);
        }
    }
}
