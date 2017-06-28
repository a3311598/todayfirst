package Service;


import Dao.AdminDao;
import Dao.AdminDaoImp;
import Domain.Admin;

public class AdminServiceImp implements AdminService{
	AdminDao dao = new AdminDaoImp();
	@Override
	public Admin loginAdmin(String account,String password) {
		return dao.login(account,password);
	}
}
