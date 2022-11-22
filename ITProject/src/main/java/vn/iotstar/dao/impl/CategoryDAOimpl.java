package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.productModel;
import vn.iotstart.dao.ICategoryDAO;

public class CategoryDAOimpl extends DBConnection implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category";
		try {
			Connection conn = super.getConnection();
			// PreparedStatement: dung duoc cho cau sql co tham so va khong co tham so
			// Statement: dung duoc voi cau co tham so
			PreparedStatement ps = conn.prepareStatement(sql); // nem cau sql vao cho phat phat prepare
			// thiet lap tham so cho phat bieu
			// thuc thi phat bieu tra ve ResultSet
			ResultSet rs = ps.executeQuery(); // chon ra
												// executeUpdate: chinh csdl
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCateId(rs.getInt("categoryId")); // ten truong trong db
				category.setCateName(rs.getString("categoryName"));
				category.setImages(rs.getString(3)); // so thu tu cot trong db
				category.setStatus(rs.getInt("status"));
				categories.add(category); // them vao LIST
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories; // tra ve LIST cac cotegory
	}

	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE Category SET categoryName = ?,images = ?, status=? WHERE categoryId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCateName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCateId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModel get(int id) {
		String sql = "SELECT * FROM Category WHERE categoryId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCateId(rs.getInt("categoryId")); // ten truong trong db
				category.setCateName(rs.getString("categoryName"));
				category.setImages(rs.getString(3)); // so thu tu cot trong db
				category.setStatus(rs.getInt("status"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Category(categoryId,categoryName,images,status) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, category.getCateId());
			ps.setString(2, category.getCateName());
			ps.setString(3, category.getImages());
			ps.setInt(4, category.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE categoryId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		CategoryDAOimpl dao = new CategoryDAOimpl();
		CategoryModel c = new CategoryModel();
//		dao.delete(6);
		c= dao.get(2);
		System.out.println(c);
	}
}
