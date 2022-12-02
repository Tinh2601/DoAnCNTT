package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.keyvalue.TiedMapEntry;

import vn.iotstar.config.DBConnection;
import vn.iotstar.entity.Cart;
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
	public User Insert_Login(String user_name, String email, String fullname, String image,int roleid,int sellerid,int status) {
		String query = "INSERT INTO dbo.Users([username], [email], [fullname],[images],[roleId],[sellerid],[status]) VALUES(?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user_name);
			ps.setString(2, email);
			ps.setString(3, fullname);
			ps.setString(4, image);

			ps.setInt(5, roleid);
			ps.setInt(6,sellerid);
			ps.setInt(7, status);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public Cart Insert_Cart(int userid,Timestamp buyDate,int status) {
		String query = "INSERT INTO dbo.Cart([userId], [buyDate], [status]) VALUES(?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userid);
			ps.setTimestamp(2, buyDate);
			ps.setInt(3, status);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public CartItem Insert_CartItem(int quantity,float unitprice,int productId,int Cartid) {
		String query = "INSERT INTO dbo.CartItem([quantity], [unitPrice], [productId],[cartId]) VALUES(?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setFloat(2, unitprice);
			ps.setInt(3, productId);
			ps.setInt(4, Cartid);
			
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public CartItem Update_CartItem(int quantity,float unitprice,int productId,int Cartid,int cartItemId) {
		String query = "UPDATE [CartItem] SET quantity =?,unitPrice=?,productId=?,cartId=? WHERE cartItemId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setFloat(2, unitprice);
			ps.setInt(3, productId);
			ps.setInt(4, Cartid);
			ps.setInt(5, cartItemId);
			
			
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
	public Cart CheckCartStatus(int userid,int status) {
		ResultSet rs = null;
		Cart cart=new Cart();
		String query = "select * from Cart where userId=? and status=?";
		try {
			
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps = con.prepareStatement(query);
			ps.setInt(1, userid);
			ps.setInt(2, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				cart.setCartId(rs.getInt("cartId"));
				cart.setUser(null);
				cart.setBuyDate(rs.getTimestamp("buyDate"));
				cart.setStatus(rs.getInt("status"));
				
				return cart;
			}
		} catch (Exception e) {
		}
		return null;
	}
	public CartItem CheckCartItemStatus(int cartid,int productid) {
		ResultSet rs = null;
		CartItem cartitem=new CartItem();
		String query = "select * from CartItem where cartId=? and productId=?";
		try {
			
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps = con.prepareStatement(query);
			ps.setInt(1, cartid);
			ps.setInt(2, productid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart=new Cart();
				cart.setCartId(rs.getInt("cartId"));
				Product pro=new Product();
				pro.setProductId(rs.getInt("productId"));
				cartitem.setCartItemId(rs.getInt("cartItemId"));
				cartitem.setQuantity(rs.getInt("quantity"));
				cartitem.setUnitPrice(rs.getInt("unitPrice"));
				cartitem.setProduct(pro);
				cartitem.setCart(cart);
				
				
				return cartitem;
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
