package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.Product;

public class CartItemDaoImpl {
	public List<CartItem> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<CartItem> query = enma.createNamedQuery("CartItem.findAll", CartItem.class);
		return query.getResultList();
	}


	public void update(CartItem cartitem) {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.merge(cartitem);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public void delete(String cartItemId) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			CartItem cartitem = enma.find(CartItem.class, cartItemId);
			if (cartitem != null) {
				enma.remove(cartitem);
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
	
	public void insert(CartItem cartitem) {
		EntityManager enma = JpaConfig.getEntityManager(); 
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.persist(cartitem); 
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
		CartItemDaoImpl dao = new CartItemDaoImpl();

		List<CartItem> l1 = dao.findAll();
		System.out.println(l1);

//		System.out.println("-----------------------------------------------------------------");
//
//		List<UserRole> l2 = dao.findByRolename("admin");
//		System.out.println(l2);
//
//		System.out.println("-----------------------------------------------------------------");

		CartItem c1 = new CartItem();
		c1.setCartItemId("1");
		c1.setQuantity(100);
		Cart c = new Cart();
		
		c.setCartId("1");
		Product p = new Product();
		p.setProductId(1);
		
		c1.setCart(c);
		c1.setProduct(p);
		
//		dao.insert(c1);
//		
//		r1.setRoleId(4);
//		r1.setRoleName("nước chanh");
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
