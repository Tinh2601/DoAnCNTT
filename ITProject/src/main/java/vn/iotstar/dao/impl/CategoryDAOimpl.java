package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Category;

public class CategoryDaoImpl {


	public List<Category> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

	public List<Category> findByCategoryname(String categoryName) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM Category c WHERE c.categoryName like :categoryName";
		TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
		query.setParameter("categoryName", "%" + categoryName + "%");
		return query.getResultList();
	}


	public void update(Category category) {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.merge(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public void delete(int categoryId) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			Category category = enma.find(Category.class, categoryId);
			if (category != null) {
				enma.remove(category);
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
	
	public void insert(Category category) {
		EntityManager enma = JpaConfig.getEntityManager(); 
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.persist(category); 
			trans.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback(); 
			throw e;
		} finally {
			enma.close(); 
		}
	}

	public static void main(String[] args) {
		CategoryDaoImpl dao = new CategoryDaoImpl();

		List<Category> l1 = dao.findAll();
		System.out.println(l1);

		System.out.println("-----------------------------------------------------------------");

		List<Category> l2 = dao.findByCategoryname("Bitis");
		System.out.println(l2);

		System.out.println("-----------------------------------------------------------------");

		Category c1 = new Category();

		c1.setCategoryName("nước ngọt");
		c1.setCategoryId(0);
		
		dao.insert(c1);
		
//		c1.setCategoryId(6);
//		c1.setCategoryName("Bitis");
//		c1.setImages("https://upload.wikimedia.org/wikipedia/vi/thumb/3/37/Bitis_logo.svg/1200px-Bitis_logo.svg.png");
//		c1.setStatus(6);
//		dao.update(c1);
		
//		try {
//			dao.delete(6);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
