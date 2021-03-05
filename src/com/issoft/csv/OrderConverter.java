package com.issoft.csv;

import com.issoft.model.Order;
import com.issoft.model.Product;
import com.issoft.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class OrderConverter {

    public static Order parseOrder(final String data, final String separator) {
        String[] fields = data.split(separator);
        Integer id = Integer.parseInt(fields[OrderFields.ID.ordinal()]);
        Date date = DateUtil.getDate(fields[OrderFields.DATE.ordinal()]);

        return new Order(id, date);
    }
}
