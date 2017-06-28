package Service;

import java.util.List;

import Dao.NewsDao;
import Dao.NewsDaoImp;
import Domain.News;

public class NewsServiceImp implements NewsService {
	NewsDao dao = new NewsDaoImp();
	@Override
	public News addNews(News passage) {
		return dao.add(passage);
	}

	@Override
	public News deleteNews(Integer id) {
		return dao.delete(id);
	}

	@Override
	public News updateNews(News passage) {
		return dao.update(passage);
	}

	@Override
	public News searchNews(Integer id) {
		return dao.search(id);
	}

	@Override
	public List<News> search(String headline) {
		return dao.search(headline);
	}

}
