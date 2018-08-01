package com.project.service;

import com.project.model.cachetest.Product;

public interface CacheTestService {

    Product getByName(String name);

    Product getByNameCacheable(String name);

    Product getByNameCacheEvict(String name);

    Product putToCache(String name);

    Iterable<Product> getByIdFromRepo();

    Iterable<Product> getByIdCacheableFromRepo();

    Product addNewProduct();

    void deleteRepoById(Long id);

    Product setNewNameForProduct(Product product);
}
