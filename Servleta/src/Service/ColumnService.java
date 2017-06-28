package Service;

import java.util.List;

import Domain.Column;
import Domain.News;

public interface ColumnService {
	public Column addColumn(Column column);
	public Column deleteColumn(Integer id);
	public Column updateColumn(Column column);
	public Column searchColumn(Column column);
	public List<Column> search(String columnname);
}
