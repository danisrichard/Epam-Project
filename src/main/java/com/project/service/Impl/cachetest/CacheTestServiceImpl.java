package com.project.service.Impl.cachetest;

import com.project.model.cachetest.Product;
import com.project.repository.ProductRepository;
import com.project.service.CacheTestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CacheTestServiceImpl implements CacheTestService {

    private static final Logger logger = LogManager.getLogger(CacheTestServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getByName(String name) {
        slowLookupOperation();
        return new Product(name, 500);
    }

    @Override
    @Cacheable(value = {"product"})
    public Product getByNameCacheable(String name) {
        slowLookupOperation();
        return new Product(name, 5000);
    }

    @Override
    @CachePut(value = "product")
    public Product putToCache(String name) {
        slowLookupOperation();
        return new Product(name, 500000);
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public Product getByNameCacheEvict(String name) {
        slowLookupOperation();
        return new Product(name, 50000);
    }

    public Iterable<Product> getByIdFromRepo() {
        logger.info("Repo called");
        return productRepository.findAll();
    }

    @Override
    @Cacheable(value = "products")
    public Iterable<Product> getByIdCacheableFromRepo() {
        logger.info("Repo called: cache");
        return productRepository.findAll();
    }

    @Override
    @CachePut(value = "products", key = "#product.id")
    public Product setNewNameForProduct(Product product) {
        product.setName("dsadsad");
        return product;
    }

    @Override
    @CachePut(value = "products")
    public Product addNewProduct() {
        return new Product("New product",5000);
    }

    @Override
    public void deleteRepoById(Long id) {
        productRepository.findById(id).ifPresent(product -> productRepository.delete(product));
    }

    private void slowLookupOperation() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
