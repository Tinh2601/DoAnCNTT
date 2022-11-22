package vn.iotstart.dao;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface ICategoryDAO {
	
	List<CategoryModel> findAll();
	void edit(CategoryModel category);
	CategoryModel get(int id);
	void insert(CategoryModel category);
	void delete(int id);
}
