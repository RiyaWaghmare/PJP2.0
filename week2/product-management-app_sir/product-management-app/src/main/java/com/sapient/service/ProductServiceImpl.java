package com.sapient.service;

import java.util.List;

import javax.persistence.PersistenceException;

import com.sapient.data.ProductDAO;
import com.sapient.data.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDao=new ProductDaoImpl();
	
	@Override
	public Integer addNewProduct(Product product) throws ProductException {
		try {
			return productDao.addNewProduct(product);
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}
		
		
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		try {
			return productDao.getAllProducts();
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}
	}

	@Override
	public Double getProductPrice(Integer productId) throws ProductException {
		//TO DO
		return null;
	}

	@Override
	public Integer deleteProduct(Integer productId) throws ProductException {
		try {
			return productDao.deleteProduct(productId);
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}	
	}

	@Override
	public Integer updateProduct(Product product) throws ProductException {
		try {
			return productDao.updateProduct(product);
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}	
	}

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		try {
			return productDao.getProductById(productId);
		}catch(PersistenceException e) {
			throw new ProductException(e.getMessage(),e);
		}	
	}

}
