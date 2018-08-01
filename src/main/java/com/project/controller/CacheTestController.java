package com.project.controller;

import com.project.model.cachetest.Product;
import com.project.service.CacheTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/cache")
public class CacheTestController {

    @Autowired
    private CacheTestService testService;

    @GetMapping("/wocache")
    public List<Product> getProductByNameWithOutCache() {
        return getProductsList(testService.getByName("Lorem ipsum"));
    }

    @GetMapping("/wcache")
    public List<Product> getProductByNameWithCache() {
        return getProductsList(testService.getByNameCacheable("Lorem ipsum"));
    }

    @GetMapping("/puttocache")
    public void puttocache() {
        testService.putToCache("Lorem ipsum1");
    }

    @GetMapping("/repo-cache")
    public Iterable<Product> getProductFromRepoCache() {
        return testService.getByIdCacheableFromRepo();
    }

    @GetMapping("/repo-save")
    public void saveProductToRepoAndCache() {
        Product product = StreamSupport.stream(testService.getByIdCacheableFromRepo().spliterator(), false).findFirst().get();
        testService.setNewNameForProduct(product);
    }

    @GetMapping("/add-product")
    public void addNewProduct(){
        testService.addNewProduct();
    }

    @GetMapping("/repo")
    public Iterable<Product> getProductFromRepo() {
        return testService.getByIdFromRepo();
    }

    private ArrayList<Product> getProductsList(Product product) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        productArrayList.add(product);
        productArrayList.add(product);
        productArrayList.add(product);
        return productArrayList;
    }
}
