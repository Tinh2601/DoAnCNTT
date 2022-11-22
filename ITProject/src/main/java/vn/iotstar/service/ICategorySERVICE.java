package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface ICategorySERVICE {
	//dinh nghia cac ham trong interface
		List<CategoryModel> findAll();
		void edit(CategoryModel category);
		CategoryModel get(int id);
		void insert(CategoryModel category);
		void delete(int id);
}
