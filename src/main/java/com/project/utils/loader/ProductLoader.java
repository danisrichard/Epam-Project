package com.project.utils.loader;

import com.project.model.cachetest.Product;
import com.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductLoader {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void load(){
        List<Product> productList = getProductList();
        productList.forEach(aProductList -> productRepository.save(aProductList));
    }

    private List<Product> getProductList() {
        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.add(new Product("Ricsko",5000));
        productArrayList.add(new Product("Ricsko",5000));
        productArrayList.add(new Product("Ricsko",5000));
        return productArrayList;
    }
}
