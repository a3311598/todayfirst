package Service;

import java.sql.ResultSet;

import Domain.Admin;

public interface AdminService {
	public Admin loginAdmin(String account,String password);
}
