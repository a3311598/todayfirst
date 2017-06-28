package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.News;
import Domain.User;
import getConnection.ConnectionFactory;

public class NewsDaoImp implements NewsDao {

	@Override
	public News add(News passage) {
		Connection conn=null;
		int count=0;
		try {
			conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into article(headline,content,headname) value(?,?,?)");
			ps.setString(1, passage.getHeadline());
			ps.setString(2, passage.getContent());
			ps.setString(3, passage.getHeadname());
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
		return null;
	}

	@Override
	public News delete(Integer id) {
		int  count=0;
		Connection conn=null;
		
		 try {
			conn = ConnectionFactory.getConnection();	
			PreparedStatement  statement = conn.prepareStatement("delete from article where id=?");
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
		
		return null;
	}

	@Override
	public News update(News passage) {
		int count = 0;
		Connection conn = null;
		try {
			 conn = ConnectionFactory.getConnection(); 
			 PreparedStatement statement = conn.prepareStatement("update article set headline=?,content=?,headname=?  where id=?" );
			 statement.setString(1,passage.getHeadline());
			 statement.setString(2,passage.getContent());
			 statement.setString(3,passage.getHeadname());
			 statement.setInt(4,passage.getId());
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

		return null;
	}

	@Override
	public News search(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		News passage = null;
	
		try{
			conn = ConnectionFactory.getConnection();
			
		
				 ps = conn.prepareStatement("select * from article where id=?");
				 ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				passage = new News();
				passage.setId(rs.getInt("id"));
				passage.setViewcount(rs.getInt("viewcount"));
				passage.setHeadline(rs.getString("headline"));
				passage.setHeadname(rs.getString("headname"));
				passage.setContent(rs.getString("content"));
				passage.setContent(rs.getString("headname"));
				passage.setCreationtime(rs.getTimestamp("creationtime"));
				passage.setThumb(rs.getString("thumb"));
				passage.setHeadimg(rs.getString("headimg"));
				
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
		return passage;
	}
	

	@Override
	public List<News> search(String headline) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<News> newList = null;
		try{
			conn = ConnectionFactory.getConnection();
			 newList = new ArrayList<News>();
			if(headline!=null&&!"".equals(headline)){
				 ps = conn.prepareStatement("select * from article where headline like ?");
				 ps.setString(1, headline+"%");
			}else{
				 ps = conn.prepareStatement("select * from article");
			}
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				News passage = new News();
				passage.setId(rs.getInt("id"));
				passage.setViewcount(rs.getInt("viewcount"));
				passage.setHeadline(rs.getString("headline"));
				passage.setHeadname(rs.getString("headname"));
				passage.setContent(rs.getString("content"));
				passage.setCreationtime(rs.getTimestamp("creationtime"));
				passage.setThumb(rs.getString("thumb"));
				passage.setHeadimg(rs.getString("headimg"));
				newList.add(passage);
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
		return newList;
	}

}
