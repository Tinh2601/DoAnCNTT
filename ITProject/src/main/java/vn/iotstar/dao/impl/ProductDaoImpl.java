package vn.iotstar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.Seller;

public class ProductDaoImpl {


	public List<Product> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);
		return query.getResultList();
	}

	public List<Product> getProductByCID(int categoryId) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p join p.category where p.category.categoryId LIKE ?1";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		query.setParameter(1, categoryId);
		return query.getResultList();
	}

	public void insert(Product product) {
		EntityManager enma = JpaConfig.getEntityManager(); 
		EntityTransaction trans = enma.getTransaction(); 
		try {
			trans.begin();
			enma.persist(product); 
			trans.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback(); 
			throw e;
		} finally {
			enma.close(); 
		}
	}

	public void update(Product product) {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.merge(product);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public void delete(int productId) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			Product product = enma.find(Product.class, productId);
			if (product != null) {
				enma.remove(product);
			} else {
				throw new Exception("Không tìm thấy !");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public List<Product> findByProductName(String productName) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p WHERE p.productName like :productName";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class); // createQuery # createNamedQuery
		query.setParameter("productName", "%" + productName + "%");
		return query.getResultList();
	}
	
	public Product findProductByID(int productId) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p WHERE p.productId like :productId";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class); // createQuery # createNamedQuery
		query.setParameter("productId",productId);
		return query.getSingleResult();
	}
	

	public Product findTop1Price() {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p order by p.price desc";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		return query.setMaxResults(1).getSingleResult();
	}

	public Product findLast1Product() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);
		return query.setMaxResults(1).getSingleResult();
	}

	public List<Product> findBestAmount() {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p ORDER BY amount DESC";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		List<Product> listAll = query.getResultList();
		List<Product> top4 = new ArrayList<Product>();
		int i = 0;
		for (Product product : listAll) {
			if (i < 4) {
				top4.add(product);
				i++;
			}else {
				break;
			}
		}
		return top4;
	}
	
	public List<Product> findLastProduct() {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p ORDER BY createDate ASC";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		List<Product> listAll = query.getResultList();
		List<Product> top4 = new ArrayList<Product>();
		int i = 0;
		for (Product product : listAll) {
			if (i < 4) {
				top4.add(product);
				i++;
			}else {
				break;
			}
		}
		return top4;
	}
	
	
	
	public List<Product> getTop3() {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT p FROM Product p ORDER BY amount DESC";
		TypedQuery<Product> query = enma.createQuery(jpql, Product.class);
		List<Product> listAll = query.getResultList();
		List<Product> top3 = new ArrayList<Product>();
		int i = 0;
		for (Product product : listAll) {
			if (i < 3) {
				top3.add(product);
				i++;
			}else {
				break;
			}
		}
		return top3;
	}

	public static void main(String[] args) {
		ProductDaoImpl dao = new ProductDaoImpl();

		
//		  List<Product> l1 = dao.findAll(); System.out.println(l1);
//		  
//		  System.out.println(
//		  "-----------------------------------------------------------------");
//		  
//		  List<Product> l2 =
//		  dao.findByProductName("Giày Thể Thao Nam Hunter X DSMH10500XAM (Xám)");
//		  System.out.println(l2);
//		  
//		  System.out.println(
//		  "-----------------------------------------------------------------");
		  
		  List<Product> l3 = dao.getProductByCID(1); System.out.println(l3);
		  
		  System.out.println(
		  "-----------------------------------------------------------------");
		  
//		  Product l4 = dao.findLastProduct(); System.out.println(l4);
//		  
//		  System.out.println(
//		  "-----------------------------------------------------------------");
//		  
//		  Product l5 = dao.findTop1Price(); System.out.println(l5);
//		  
//		  System.out.println(
//		  "-----------------------------------------------------------------");
		 
		
		
//		List<Product> l6 = dao.getTop4();
//		System.out.println(l6);
//
//		System.out.println("-----------------------------------------------------------------");
		


		Category c1 = new Category();
		c1.setCategoryId(1);
		Seller s1 = new Seller();
		s1.setSellerId(1);
		Product p1 = new Product();

		p1.setProductName("nước ngọt");
		p1.setStatus(2);
		p1.setCategory(c1);
		p1.setSeller(s1);

//		dao.insert(p1);

		p1.setProductId(26);
		p1.setAmount(1000);
//		dao.update(p1);

		/*
		 * try { dao.delete(26); } catch (Exception e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
	}
}
