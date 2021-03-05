package com.issoft.runner;

import com.issoft.service.OrderService;
import com.issoft.util.Printer;

public class Runner {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        System.out.println(Printer.convertToPrettyString(orderService.calculate()));
    }
}
