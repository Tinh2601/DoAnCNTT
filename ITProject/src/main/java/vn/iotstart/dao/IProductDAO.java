package vn.iotstart.dao;

import java.util.List;

import vn.iotstar.model.productModel;

public interface IProductDAO {
	List<productModel> findAll();
	productModel findTopOne();
	List<productModel> findLastProduct();
	List<productModel> findBestAmount();
}
