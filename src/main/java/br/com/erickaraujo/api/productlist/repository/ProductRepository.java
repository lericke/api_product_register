package br.com.erickaraujo.api.productlist.repository;

import br.com.erickaraujo.api.productlist.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
