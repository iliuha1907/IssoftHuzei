package com.issoft.util;

import com.issoft.model.product.Product;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

public class Printer {

    public static String convertToPrettyString(Map<LocalDate, Product> map) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<LocalDate, Product>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<LocalDate, Product> entry = iter.next();
            sb.append(entry.getKey());
            sb.append('=').append('"');
            sb.append(entry.getValue());
            sb.append('"');
            if (iter.hasNext()) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
