package Dao;

import java.util.List;

import Domain.News;
import Domain.User;

public interface NewsDao {
	public News add(News passage);
	public News delete(Integer id);
	public News update(News passage);
	public News search(Integer id);
	public List<News> search(String headline);
}
