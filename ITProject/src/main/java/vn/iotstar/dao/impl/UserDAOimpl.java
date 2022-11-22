package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.UserModel;

public class UserDAOimpl extends DBConnection{
		//kiểm tra user nhập vào 
	public UserModel login(String user, String pass) {
		String sql = "select * from Users\n" + " where [username]=?\n" + " and password =?";
		try {
			Connection conn = super.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user); // gán cid vào trong dấu chấm hỏi thứ nhất
			ps.setString(2, pass); // gán cid vào trong dấu chấm hỏi thứ nhất
            ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserDAOimpl dao = new UserDAOimpl();
		UserModel c = dao.login("user1", "1");
		System.out.println(c);
	}
}
