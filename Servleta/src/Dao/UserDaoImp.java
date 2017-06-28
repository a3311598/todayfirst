package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.UserDao;
import Dao.UserDaoImp;

import Domain.User;
import getConnection.ConnectionFactory;

public class UserDaoImp implements UserDao{
	

	@Override
	public int add(User user)  {
		Connection conn=null;
		int count=0;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into user (account,password,name) value(?,?,?)");
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int delete(Integer id) {
		int  count=0;
		Connection conn=null;
		
		 try {
			conn = ConnectionFactory.getConnection();	
			PreparedStatement  statement = conn.prepareStatement("delete from user where id=?");
			statement.setInt(1, id);
			
			 count = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}

	@Override
	public int update(User user) {
		int count = 0;
		Connection conn = null;
		try {
			 conn = ConnectionFactory.getConnection(); 
			 PreparedStatement statement = conn.prepareStatement("update user set account=?,password=?,name=?  where id=?" );
			 statement.setString(1, user.getAccount());
			 statement.setString(2,user.getPassword() );
			 statement.setString(3, user.getName());
			 statement.setInt(4, user.getId());
			 count = statement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}

		return count;
	}

	@Override
	public List<User> search(String name) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		List<User> userList = null;
		try{
			conn = ConnectionFactory.getConnection();
			 userList = new ArrayList<User>();
			if(name!=null&&!"".equals(name)){
				 ps = conn.prepareStatement("select * from user where name like ?");
				 ps.setString(1, name+"%");
			}else{
				 ps = conn.prepareStatement("select * from user");
			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				userList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

	@Override
	public int login(User user) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			 conn = ConnectionFactory.getConnection();
			 PreparedStatement ps = conn.prepareStatement("select * from user where account=? and password=?");
			 ps.setString(1, user.getAccount());
			 ps.setString(2, user.getPassword());
			 rs = ps.executeQuery();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 try {
			
				 if(rs.next()){
				 return 1;
				 
				 }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		return 0;
		
	}

	@Override
public List<User> search(Integer id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		List<User> userList = null;
		try{
			conn = ConnectionFactory.getConnection();
			 userList = new ArrayList<User>();
			
				 ps = conn.prepareStatement("select * from user where id=?");
			
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					User user = new User();
					user.setId(id);
					user.setAccount(rs.getString("account"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					userList.add(user);
				}
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

}
