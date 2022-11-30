package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.User;

public class CartDaoImpl {
	public List<Cart> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Cart> query = enma.createNamedQuery("Cart.findAll", Cart.class);
		return query.getResultList();
	}


	public void update(Cart cart) {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.merge(cart);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public void delete(String cartId) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			Cart cart = enma.find(Cart.class, cartId);
			if (cart != null) {
				enma.remove(cart);
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
	
	public void insert(Cart cart) {
		EntityManager enma = JpaConfig.getEntityManager(); 
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.persist(cart); 
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
		CartDaoImpl dao = new CartDaoImpl();

		List<Cart> l1 = dao.findAll();
		System.out.println(l1);

//		System.out.println("-----------------------------------------------------------------");
//
//		List<UserRole> l2 = dao.findByRolename("admin");
//		System.out.println(l2);
//
//		System.out.println("-----------------------------------------------------------------");

		Cart c1 = new Cart();
		c1.setCartId("2");
		
		User u = new User();
		u.setUserId(1);
		
		
//		dao.insert(c1);
		c1.setUser(u);
		
//		dao.update(c1);
//		
		try {
			dao.delete("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}