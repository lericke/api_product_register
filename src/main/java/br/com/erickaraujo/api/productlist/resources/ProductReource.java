package br.com.erickaraujo.api.productlist.resources;

import br.com.erickaraujo.api.productlist.entity.Product;
import br.com.erickaraujo.api.productlist.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// http//localhost:8080/products
@RequestMapping("/products")
public class ProductReource {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findAll(@PathVariable Long id) {
        return this.productRepository.findById(id).get();

    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return this.productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        Product productDatabase = this.productRepository.findById(id).get();
        BeanUtils.copyProperties(product, productDatabase, "id", "createdAt");
        return this.productRepository.save(productDatabase);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}

