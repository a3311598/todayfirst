package Service;

import java.util.List;

import Domain.News;
import Domain.User;

public interface NewsService {
		public News addNews(News passage);
		public News deleteNews(Integer id);
		public News updateNews(News passage);
		public News searchNews(Integer id);
		public List<News> search(String headline);
}
