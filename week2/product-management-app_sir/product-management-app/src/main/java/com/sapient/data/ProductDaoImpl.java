package com.sapient.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.sapient.service.Product;

public class ProductDaoImpl implements ProductDAO{
	private static EntityManagerFactory EMF=
			Persistence.createEntityManagerFactory("product-management-app");

	@Override
	public Integer addNewProduct(Product product) throws PersistenceException {
		EntityManager entityManager=null;
		try {
			entityManager=EMF.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(product);
			entityManager.getTransaction().commit();			
			return entityManager
					.find(Product.class, product.getProductId())
					.getProductId();
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
		
	}

	@Override
	public List<Product> getAllProducts() throws PersistenceException {
		EntityManager entityManager=null;
		//Product is class name
		String jql="select p from Product p";
		//String jql= "From Product p";
		try {
			entityManager=EMF.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Product> query=
					entityManager.createQuery(jql, Product.class);
			List<Product> productList=query.getResultList();
			entityManager.getTransaction().commit();			
			return productList;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
	}

	@Override
	public Double getProductPrice(Integer productId) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProduct(Integer productId) throws PersistenceException {
		EntityManager entityManager=null;
		try {
			entityManager=EMF.createEntityManager();
			entityManager.getTransaction().begin();
			Product product= 
					entityManager.find(Product.class, productId);
			if(product !=null) {
				entityManager.remove(product);
				entityManager.getTransaction().commit();
				return product.getProductId();
			}else {
				return null;
			}						
			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public Integer updateProduct(Product product) throws PersistenceException {
		EntityManager entityManager=null;
		try {
			entityManager=EMF.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(product);
			entityManager.getTransaction().commit();
			return product.getProductId();			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Product getProductById(Integer productId) throws PersistenceException {
		EntityManager entityManager=null;
		//Product is class name and productId is property name
		//pid is named parameter
		String jql="select p from Product p where p.productId=:pid";
		
		try {
			entityManager=EMF.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Product> query=
					entityManager.createQuery(jql, Product.class);
			query.setParameter("pid", productId);
			Product product=query.getSingleResult();
			entityManager.getTransaction().commit();			
			return product; 
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
	}

	

}
