package Dao;

import java.util.List;

import Domain.Advertisement;


public interface AdDao {	
	
	public List<Advertisement> list(String name);

	public int add(Advertisement adadd);

	public  Advertisement remove(Advertisement adrm);
}
