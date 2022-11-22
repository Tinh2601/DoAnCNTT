package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import vn.iotstar.service.ICategorySERVICE;
import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.productModel;
//import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstart.dao.IProductDAO;

public class ProductDaoImpl extends DBConnection implements IProductDAO {
	//ICategorySERVICE categorySERVICE=new CategoryServiceImpl();
	@Override
	public List<productModel> findAll() {
		List<productModel> products = new ArrayList<productModel>();
        String sql = "SELECT * FROM Product";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	productModel product = new productModel();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductCode(rs.getInt("productCode"));         
                product.setCategoryId(rs.getInt("categoryId"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getFloat("price"));
                product.setAmount(rs.getInt("amount"));
                product.setStock(rs.getInt("stock"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
                product.setSellerId(rs.getInt("sellerId"));
//                product.setCategory(categorySERVICE.get(product.getProductId()));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
	}

	@Override
	public productModel findTopOne() {		
        String sql = "SELECT TOP 1 * FROM Product order by productId desc ";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
				return new productModel(
						rs.getInt("productId"),
						rs.getString("productName"),
						rs.getInt("productCode"), 						
						rs.getInt("categoryId"),
						rs.getString("description"),
						rs.getFloat("price"),
						rs.getInt("amount"),
						rs.getInt("stock"),
						rs.getString("images"),
						rs.getInt("status"),
						rs.getInt("wishlist"),
						rs.getDate("createDate"),
						rs.getInt("sellerId"));
			}
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<productModel> findLastProduct() {
		List<productModel> products = new ArrayList<productModel>();
        String sql = "SELECT TOP 4 * FROM Product ORDER BY createDate ASC";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	productModel product = new productModel();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductCode(rs.getInt("productCode"));         
                product.setCategoryId(rs.getInt("categoryId"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getFloat("price"));
                product.setAmount(rs.getInt("amount"));
                product.setStock(rs.getInt("stock"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
                product.setSellerId(rs.getInt("sellerId"));
//                product.setCategory(categorySERVICE.get(product.getProductId()));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
	}

	@Override
	public List<productModel> findBestAmount() {
		List<productModel> products = new ArrayList<productModel>();
        String sql = "SELECT TOP 4 * FROM Product ORDER BY amount DESC";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	productModel product = new productModel();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductCode(rs.getInt("productCode"));         
                product.setCategoryId(rs.getInt("categoryId"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getFloat("price"));
                product.setAmount(rs.getInt("amount"));
                product.setStock(rs.getInt("stock"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
                product.setSellerId(rs.getInt("sellerId"));
//                product.setCategory(categorySERVICE.get(product.getProductId()));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
	}
	
	
	public List<productModel> getAllProductByCID(String cid) {
		List<productModel> products = new ArrayList<productModel>();
        String sql = "SELECT * FROM Product where categoryId=?";
        try {
            Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	productModel product = new productModel();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductCode(rs.getInt("productCode"));         
                product.setCategoryId(rs.getInt("categoryId"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getFloat("price"));
                product.setAmount(rs.getInt("amount"));
                product.setStock(rs.getInt("stock"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setWishlist(rs.getInt("wishlist"));
                product.setCreateDate(rs.getDate("createDate"));
                product.setSellerId(rs.getInt("sellerId"));
//                product.setCategory(categorySERVICE.get(product.getProductId()));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
	}
	
	public productModel getProductByID(String pid) {

		 String sql = "select * from Product where productId = ?";
	        try {
	            Connection conn = super.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, pid);
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) {
					return new productModel(
							rs.getInt("productId"),
							rs.getString("productName"),
							rs.getInt("productCode"), 						
							rs.getInt("categoryId"),
							rs.getString("description"),
							rs.getFloat("price"),
							rs.getInt("amount"),
							rs.getInt("stock"),
							rs.getString("images"),
							rs.getInt("status"),
							rs.getInt("wishlist"),
							rs.getDate("createDate"),
							rs.getInt("sellerId"));
				}
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	//
	
	// Phan trang
	//select total account
		public int getTotalProduct() {
			String sql = "select count(*) from Product";
			try {
				Connection conn = super.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return 0;
		}
		
		//
		public List<productModel> pagingProduct(int index){
			List<productModel> list = new ArrayList<>();
			String sql = "select * from Product \r\n"
					+ "order by productId\r\n"
					+ "offset ? rows fetch next 5 rows only;";
			try {
				Connection conn = super.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1,(index-1)*5);
	            ResultSet rs = ps.executeQuery();	
				while (rs.next()) {
					list.add(new productModel(
							rs.getInt("productId"),
							rs.getString("productName"),
							rs.getInt("productCode"), 						
							rs.getInt("categoryId"),
							rs.getString("description"),
							rs.getFloat("price"),
							rs.getInt("amount"),
							rs.getInt("stock"),
							rs.getString("images"),
							rs.getInt("status"),
							rs.getInt("wishlist"),
							rs.getDate("createDate"),
							rs.getInt("sellerId")));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
		}
	
	//search
		public List<productModel> searchProduct(String name) {
			List<productModel> products = new ArrayList<productModel>();
	        String sql = "select * from Product where productName like ?";
	        try {
	            Connection conn = super.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, "%"+name+"%");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	productModel product = new productModel();
	                product.setProductId(rs.getInt("productId"));
	                product.setProductName(rs.getString("productName"));
	                product.setProductCode(rs.getInt("productCode"));         
	                product.setCategoryId(rs.getInt("categoryId"));
	                product.setDescription(rs.getString("description"));
	                product.setPrice(rs.getFloat("price"));
	                product.setAmount(rs.getInt("amount"));
	                product.setStock(rs.getInt("stock"));
	                product.setImage(rs.getString("images"));
	                product.setStatus(rs.getInt("status"));
	                product.setWishlist(rs.getInt("wishlist"));
	                product.setCreateDate(rs.getDate("createDate"));
	                product.setSellerId(rs.getInt("sellerId"));
//	                product.setCategory(categorySERVICE.get(product.getProductId()));
	                products.add(product);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return products;
		}
		
	//
		public List<productModel> getNext3Product(int amount) {
			List<productModel> products = new ArrayList<productModel>();
	        String sql = "SELECT * FROM Product ORDER BY productId OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
	        try {
	            Connection conn = super.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, amount);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	productModel product = new productModel();
	                product.setProductId(rs.getInt("productId"));
	                product.setProductName(rs.getString("productName"));
	                product.setProductCode(rs.getInt("productCode"));         
	                product.setCategoryId(rs.getInt("categoryId"));
	                product.setDescription(rs.getString("description"));
	                product.setPrice(rs.getFloat("price"));
	                product.setAmount(rs.getInt("amount"));
	                product.setStock(rs.getInt("stock"));
	                product.setImage(rs.getString("images"));
	                product.setStatus(rs.getInt("status"));
	                product.setWishlist(rs.getInt("wishlist"));
	                product.setCreateDate(rs.getDate("createDate"));
	                product.setSellerId(rs.getInt("sellerId"));
//	                product.setCategory(categorySERVICE.get(product.getProductId()));
	                products.add(product);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return products;
	    }
	
		//lấy 3 sản phẩm để làm ajax load sản phẩm
		public List<productModel> getTop3(){
			List<productModel> products = new ArrayList<productModel>();
	        String sql = "select top 3 * from Product ";
	        try {
	            Connection conn = super.getConnection();
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	productModel product = new productModel();
	                product.setProductId(rs.getInt("productId"));
	                product.setProductName(rs.getString("productName"));
	                product.setProductCode(rs.getInt("productCode"));         
	                product.setCategoryId(rs.getInt("categoryId"));
	                product.setDescription(rs.getString("description"));
	                product.setPrice(rs.getFloat("price"));
	                product.setAmount(rs.getInt("amount"));
	                product.setStock(rs.getInt("stock"));
	                product.setImage(rs.getString("images"));
	                product.setStatus(rs.getInt("status"));
	                product.setWishlist(rs.getInt("wishlist"));
	                product.setCreateDate(rs.getDate("createDate"));
	                product.setSellerId(rs.getInt("sellerId"));
//	                product.setCategory(categorySERVICE.get(product.getProductId()));
	                products.add(product);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return products;
		}
		
	public static void main(String[] args) {
		ProductDaoImpl dao = new ProductDaoImpl();
		List<productModel> list = dao.findAll();
		
		for (productModel o : list) {
			System.out.println(o);
		}
//		productModel p = dao.getProductByID("2");
//		System.out.println(p);
	}
}
