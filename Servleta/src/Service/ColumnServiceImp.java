package Service;

import java.util.List;

import Dao.ColumnDao;
import Dao.ColumnDaoImp;
import Domain.Column;

public class ColumnServiceImp implements ColumnService {
	ColumnDao dao = new ColumnDaoImp();
	@Override
	public Column addColumn(Column column) {
		return dao.add(column);
	}

	@Override
	public Column deleteColumn(Integer id) {
		return dao.delete(id);
	}

	@Override
	public Column updateColumn(Column column) {
		return dao.update(column);
	}

	@Override
	public Column searchColumn(Column column) {
		return dao.search(column);
	}

	@Override
	public List<Column> search(String columnname) {
		return dao.search(columnname);
	}

}
