package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Seller;
import vn.iotstar.entity.User;
import vn.iotstar.entity.UserRole;



public class UserDaoImpl {
	
	
	public User login(String user, String pass) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "select u from User u join u.userRole where u.username LIKE ?1 and u.password LIKE ?2 ";
		TypedQuery<User> query = enma.createQuery(jpql, User.class); // createQuery # createNamedQuery
		query.setParameter(1, user);
		query.setParameter(2, pass);		
		return query.getSingleResult();	
	}
	
	
	public void update(User user) {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.merge(user); 
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	
	public void delete(int userId) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			User user = enma.find(User.class, userId); 
			if (user != null) {
				enma.remove(user); 
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
	
	public void insert(User user) {
		EntityManager enma = JpaConfig.getEntityManager(); 
		EntityTransaction trans = enma.getTransaction(); 
		try {
			trans.begin();
			enma.persist(user); 
			trans.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback(); 
			throw e;
		} finally {
			enma.close(); 
		}
	}
	
	public List<User> findByUsername(String username) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT u FROM User u WHERE u.username like :username";
		TypedQuery<User> query = enma.createQuery(jpql, User.class); // createQuery # createNamedQuery
		query.setParameter("username", "%" + username + "%");
		return query.getResultList();
	}
	
	public List<User> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	
	
	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		
		/*
		 * User c = dao.login("tinh", "1"); System.out.println(c);
		 */
		
		
		  Seller seller2 = new Seller(); seller2.setSellerId(3);
		  
		  UserRole userrole = new UserRole(); userrole.setRoleId(3);
		  
		  User c2 = new User(); c2.setPhone("0708128879");
		  c2.setFullname("Nguyen Tinh"); c2.setSeller(seller2);
		  c2.setUserRole(userrole); dao.insert(c2);
		 
		
//		try {
//			dao.delete(7);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		  
		  
			/*
			 * c2.setUserId(8); // phải set id cho thuộc tính update ( phải biết là update
			 * cái nào ) c2.setEmail("hello world"); dao.update(c2);
			 */
		  
//		  List<User> list = dao.findByUsername("tinh");
//		  System.out.println(list);
		  
		  List<User> list = dao.findAll();
		  System.out.println(list);
		
	}
}
