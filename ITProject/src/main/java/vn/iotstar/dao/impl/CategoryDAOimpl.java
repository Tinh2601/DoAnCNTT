package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;

public class CategoryDAOimpl {
	public List<Category> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

}
