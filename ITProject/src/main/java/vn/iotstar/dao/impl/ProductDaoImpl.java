package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Product;




public class ProductDaoImpl {

	public List<Product> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);
		return query.getResultList();
	}

	public List<Product> getProductByCID(int cateID) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p join p.category where p.category.categoryId LIKE ?1";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		query.setParameter(1, cateID);
		return query.getResultList();
	}


	public Product findLastProduct() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);
		return query.setMaxResults(1).getSingleResult();
	}

	public int count() {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM Product c";
		Query query = enma.createQuery(jpql); // import persistance
		return ((Long) query.getSingleResult()).intValue();
	}
	
	public Product findTop1Price() {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p order by p.price desc";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		return query.setMaxResults(1).getSingleResult();
	}

	public List<Product> findByProductName(String txtsearch) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM Product c WHERE c.productName like :title";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class); // createQuery # createNamedQuery
		query.setParameter("title", "%" + txtsearch + "%");
		return query.getResultList();
	}
	
	
	public static void main(String[] args) {
		System.out.println("hello world");
	}
}
