
package Service;

import java.util.List;

import Dao.UserDao;
import Dao.UserDaoImp;
import Domain.Admin;
import Domain.User;

public class UserServiceImp implements UserService {
	UserDao dao = new UserDaoImp();
	@Override
	public int register(User user) {
		return dao.add(user);
	}


	@Override
	public int deleteUser(Integer id) {
		return dao.delete(id);
	}

	@Override
	public int updateUser(User user) {
		return dao.update(user);
	}
	
	@Override
	public List<User> listByname(String name) {
		return dao.search(name);
	}

	@Override
	public int loginUser(User user) {
		return dao.login(user);
	}


	@Override
	public List<User> listByname(Integer id) {
		return dao.search(id);
	}
}
