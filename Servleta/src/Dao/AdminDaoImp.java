package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Admin;
import getConnection.ConnectionFactory;

public class AdminDaoImp implements AdminDao {
	@Override
	public Admin login(String account,String password) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			Admin admin = new Admin();
			 conn = ConnectionFactory.getConnection();
			 PreparedStatement ps = conn.prepareStatement("select * from user where account=? and password=?");
			 ps.setString(1,account);
			 ps.setString(2,password);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 admin.setAccount(rs.getString("account"));
				 admin.setPassword(rs.getString("password"));
			 }
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		
		 return null;
	}
}
