package Dao;


import Domain.Admin;

public interface AdminDao {
	
	public Admin login(String account,String password);
}
