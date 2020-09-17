package com.sapient.service;


import java.util.List;



public interface ProductService {
	public Integer addNewProduct(Product product) throws ProductException;
	public List<Product> getAllProducts() throws ProductException;
	public Double getProductPrice(Integer productId) throws ProductException;
	public Integer deleteProduct(Integer productId) throws ProductException;
	public Integer updateProduct(Product product) throws ProductException;
	public Product getProductById(Integer productId) throws ProductException;
}
