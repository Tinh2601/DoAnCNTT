package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.productModel;

public interface IProductServices {
	List<productModel> findAll();
	List<productModel> findTopOne();
	List<productModel> findLastProduct();
	List<productModel> findBestAmount();
}
