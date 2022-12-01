package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBConnection;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;


public class DaoDBConection extends DBConnection  {
	/*
	 * public List<CartItem> findAll() { List<Category> categories = new
	 * ArrayList<Category>(); String sql =
	 * "select Product.images,Product.productName,Product.stock,CartItem.quantity,CartItem.unitPrice from Product Join CartItem on Product.productId=CartItem.productId where CartItem.cartId=2"
	 * ; try { Connection conn = super.getConnection(); // PreparedStatement: dung
	 * duoc cho cau sql co tham so va khong co tham so // Statement: dung duoc voi
	 * cau co tham so PreparedStatement ps = conn.prepareStatement(sql); // nem cau
	 * sql vao cho phat phat prepare // thiet lap tham so cho phat bieu // thuc thi
	 * phat bieu tra ve ResultSet ResultSet rs = ps.executeQuery(); // chon ra //
	 * executeUpdate: chinh csdl while (rs.next()) { Product product=new Product();
	 * CartItem cartitem= new CartItem(); product.setImages(rs.getString("images"));
	 * product.setProductName(rs.getString("productName"));
	 * product.setStock(rs.getInt("stock")); // ten truong trong db
	 * cartitem.setQuantity(rs.getInt("quantity"));
	 * cartitem.setUnitPrice(rs.getInt("unitPrice"));
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); } return categories; // tra ve
	 * LIST cac cotegory }
	 */

	

}
