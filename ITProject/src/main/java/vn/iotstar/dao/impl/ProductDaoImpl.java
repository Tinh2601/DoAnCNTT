package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;

public class ProductDaoImpl {

	public List<Product> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);
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

	public static void main(String[] args) {
		ProductDaoImpl dao = new ProductDaoImpl();

		// System.out.println(dao.findAll());
//		Product product = dao.findTop1Price();
//		if (product != null) {
//			System.out.println("ko lỗi !");
//		}
//		System.out.println(dao.count());
		System.out.println(dao.findTop1Price());
	}
}
