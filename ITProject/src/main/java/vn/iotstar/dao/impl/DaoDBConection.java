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
import vn.iotstar.entity.User;



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
	public User Insert_Login(String user_name, String email, String fullname, String image,int roleid,int sellerid) {
		String query = "INSERT INTO dbo.Users([username], [email], [fullname],[images],[roleId],[sellerid]) VALUES(?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user_name);
			ps.setString(2, email);
			ps.setString(3, fullname);
			ps.setString(4, image);

			ps.setInt(5, roleid);
			ps.setInt(6,sellerid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public User CheckLoginGoogle(String email) {
		ResultSet rs = null;
		User user=new User();
		String query = "select * from Users where [username]=?";
		try {
			
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setFullname(rs.getString("fullname"));
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				
				return user;
			}
		} catch (Exception e) {
		}
		return null;
	}
	/*
	 * public User CheckLoginGoogle(String email) { User String sql =
	 * "SELECT * FROM Category"; try { Connection conn = super.getConnection(); //
	 * PreparedStatement: dung duoc cho cau sql co tham so va khong co tham so //
	 * Statement: dung duoc voi cau co tham so PreparedStatement ps =
	 * conn.prepareStatement(sql); // nem cau sql vao cho phat phat prepare // thiet
	 * lap tham so cho phat bieu // thuc thi phat bieu tra ve ResultSet ResultSet rs
	 * = ps.executeQuery(); // chon ra // executeUpdate: chinh csdl while
	 * (rs.next()) { CategoryModel category = new CategoryModel();
	 * category.setCateId(rs.getInt("categoryId")); // ten truong trong db
	 * category.setCateName(rs.getString("categoryName"));
	 * category.setImages(rs.getString(3)); // so thu tu cot trong db
	 * category.setStatus(rs.getInt("status")); categories.add(category); // them
	 * vao LIST } } catch (Exception e) { e.printStackTrace(); } return categories;
	 * // tra ve LIST cac cotegory }
	 */

	

}
