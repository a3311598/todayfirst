package Dao;

import java.util.List;

import Domain.Column;
import Domain.News;

public interface ColumnDao {
	public Column add(Column column);
	public Column delete(Integer id);
	public Column update(Column column);
	public Column search(Column column);
	public List<Column> search(String columnname);
}
