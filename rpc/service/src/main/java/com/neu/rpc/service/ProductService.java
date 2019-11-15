package com.neu.rpc.service;

import com.neu.rpc.api.IProductService;
import com.neu.rpc.api.Product;

/**
 * @Title ProductService
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 9:20
 **/
public class ProductService implements IProductService {

    public Product queryById(long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("water");
        product.setPrice(1.0);
        return product;
    }
}
