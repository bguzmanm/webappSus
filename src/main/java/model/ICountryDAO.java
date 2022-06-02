package model;

import java.util.List;

public interface ICountryDAO {
	
	public boolean create(Country co);
	public List<Country> read();
	public Country read(int id);
	public Country read(String country);
	
	public boolean update(Country co);
	
	public boolean delete(Country co);
	public boolean delete(int id);
	
}
