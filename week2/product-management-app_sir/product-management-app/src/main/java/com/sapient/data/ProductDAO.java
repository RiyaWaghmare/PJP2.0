package com.sapient.data;

import java.util.List;

import javax.persistence.PersistenceException;

import com.sapient.service.Product;

public interface ProductDAO {
	public Integer addNewProduct(Product product) throws PersistenceException;
	public List<Product> getAllProducts() throws PersistenceException;
	public Double getProductPrice(Integer productId) throws PersistenceException;
	public Integer deleteProduct(Integer productId) throws PersistenceException;
	public Integer updateProduct(Product product) throws PersistenceException;
	public Product getProductById(Integer productId) throws PersistenceException;
}
