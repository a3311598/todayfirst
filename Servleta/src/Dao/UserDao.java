package Dao;

import java.util.List;
import Domain.User;

public interface UserDao {
	public int add(User user);
	public int delete(Integer id);
	public int update(User user);
	public List<User> search(String name);
	public List<User> search(Integer id);
	public int login(User user);
}
