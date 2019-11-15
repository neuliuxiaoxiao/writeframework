package com.neu.rpc.api;

import java.io.Serializable;

/**
 * @Title Product
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 8:56
 **/
public class Product implements Serializable {

    private static final long serialVersionUID = -3411805578326648322L;
    private long id;
    private String name;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
