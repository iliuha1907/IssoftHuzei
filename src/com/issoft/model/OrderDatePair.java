package com.issoft.model;

import java.util.Date;
import java.util.Objects;

public class OrderDatePair {

    private Order order;
    private Date date;

    public OrderDatePair(Order order, Date date) {
        this.order = order;
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderDatePair that = (OrderDatePair) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, date);
    }

    @Override
    public String toString() {
        return "OrderDatePair{" +
                "order=" + order +
                ", date=" + date +
                '}';
    }
}
