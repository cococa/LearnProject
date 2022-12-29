package com.cocoa.proxy;

import com.cocoa.proxy.IProductService;

public class ProductServiceImpl implements IProductService {
    @Override
    public String getInfo() {
        return "new info";
    }
}
