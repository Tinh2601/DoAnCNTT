package vn.iotstar.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.User;

public class UserDAOimpl {
		
	public User login(String user, String pass) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "select u from User u join u.userRole where u.username LIKE ?1 and u.password LIKE ?2 ";
		TypedQuery<User> query = enma.createQuery(jpql, User.class); // createQuery # createNamedQuery
		query.setParameter(1, user);
		query.setParameter(2, pass);		
		return query.getSingleResult();	
	}
	
	public static void main(String[] args) {
		UserDAOimpl dao = new UserDAOimpl();
		User c = dao.login("admin", "1");
		System.out.println(c);
	}
}
