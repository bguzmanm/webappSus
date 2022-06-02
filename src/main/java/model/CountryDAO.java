package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements ICountryDAO {

	Connection c = Conexion.getConnection();

	@Override
	public boolean create(Country co) {

		String sql = "INSERT INTO country (country) VALUES ('" + co.getCountry() + "')";
		
		try {

			Statement s = c.createStatement();

			s.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al crear");
			e.printStackTrace();
			return false;
		}

		return true;

	}

	@Override
	public List<Country> read() {

		List<Country> lista = new ArrayList<Country>();

		String sql = "select country_id, country from country";

		try {

			Statement s = c.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				lista.add(new Country(rs.getInt("country_id"), rs.getString("country")));

			}

		} catch (SQLException e) {
			System.out.println("Error en leer");
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Country read(int id) {

		Country co = null;

		String sql = "select country_id, country from country WHERE country_id = " + id;

		try {

			Statement s = c.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				co = new Country(rs.getInt("country_id"), rs.getString("country"));

			}

		} catch (SQLException e) {
			System.out.println("Error en leer");
			e.printStackTrace();
		}

		return co;
	}
	
	@Override
	public Country read(String country) {

		Country co = null;

		String sql = "select country_id, country from country WHERE country = '" + country + "'";

		try {

			Statement s = c.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				co = new Country(rs.getInt("country_id"), rs.getString("country"));

			}

		} catch (SQLException e) {
			System.out.println("Error en leer");
			e.printStackTrace();
		}

		return co;
		
	}

	

	@Override
	public boolean update(Country co) {

		String sql = "update country set country = '" + co.getCountry() + "' WHERE country_id = " + co.getCountry_id();
		
		try {

			Statement s = c.createStatement();
			s.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error en actualizar");
			e.printStackTrace();

			return false;
		}

		return true;
	}

	@Override
	public boolean delete(Country c) {
		
		return delete(c.getCountry_id());
	}

	@Override
	public boolean delete(int id) {

		String sql = "delete from country where country_id = " + id;
		
		try {

			Statement s = c.createStatement();
			s.execute(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			System.out.println("Error en borrar");
			e.printStackTrace();

			return false;
		}

		return true;
		
		
	}


}
