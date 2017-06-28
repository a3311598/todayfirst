package Service;

import java.util.List;
import Domain.User;

public interface UserService {
	public int register(User user);
	public int deleteUser(Integer id);
	public int updateUser(User user);
	public List<User> listByname(Integer id);
	public List<User> listByname(String name); 
	public int loginUser(User user);
	
}
