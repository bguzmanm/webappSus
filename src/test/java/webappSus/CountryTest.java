package webappSus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Country;
import model.CountryDAO;

public class CountryTest {
	
	CountryDAO cDAO = new CountryDAO();
	
	@Test
	public void testRead() {
	
		Country c = cDAO.read(22);		
		assertTrue(c.getCountry().equals("Chile"));
		
	}
	
	@Test
	public void testReadAll() {
		
		List<Country> lista = cDAO.read();		
		assertTrue(lista.size() == 109);
		
	}
	
	@Test
	public void testUpdate() {
		Country c = new Country(22, "Chilezuela");
		assertTrue(cDAO.update(c));
		
		c = cDAO.read(22);
		assertTrue(c.getCountry().equals("Chilezuela"));
		
		c.setCountry("Chile");
		assertTrue(cDAO.update(c));
		
	}
	
	@Test
	public void testCreate() {
		
		Country c = new Country(0, "Chilelandia");
		cDAO.create(c);
		List<Country> lista = cDAO.read();
		
		boolean encontrado = false;
		
		for (Country country : lista) {
			if (country.getCountry().equals("Chilelandia"))
				encontrado = true;
		}
		
		assertTrue(encontrado);
	}
	
	@Test
	public void testDelete() {
		
		Country c = cDAO.read("Chilelandia");
		
		assertTrue(cDAO.delete(c));
		
		Country c2 = cDAO.read(c.getCountry_id());
		
		assertNotEquals(c, c2);
	}

}
