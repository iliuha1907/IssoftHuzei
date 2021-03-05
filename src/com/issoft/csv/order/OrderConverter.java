package com.issoft.csv.order;

import com.issoft.model.order.Order;
import com.issoft.util.DateUtil;

import java.time.LocalDate;

public class OrderConverter {

    public static Order parseOrder(final String data, final String separator) {
        String[] fields = data.split(separator);
        String id = fields[OrderFields.ID.ordinal()];
        LocalDate date = DateUtil.getDate(fields[OrderFields.DATE.ordinal()]);

        return new Order(id, date);
    }
}
