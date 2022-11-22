package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.productModel;
import vn.iotstar.service.IProductServices;
import vn.iotstart.dao.IProductDAO;

public class ProductServiceImpl implements IProductServices{
	
	IProductDAO dao = new ProductDaoImpl();
	@Override
	public List<productModel> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<productModel> findTopOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<productModel> findLastProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<productModel> findBestAmount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
