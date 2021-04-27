package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class DataManagementTest extends TestCase {

	private DataManagement dm;
	
	private void setUpEscenary1() {
		dm = new DataManagement();
		dm.addPlayer("michael", "CHI", 1990, 40, 2, 1, 20, 39, 0.4, 20);
		dm.addPlayer("cobe", "CHI", 1985, 40, 2, 1, 20, 39, 0.4, 20);
		dm.addPlayer("lebron", "CHI", 1995, 40, 2, 1, 20, 39, 0.4, 20);
		dm.addPlayer("lebron", "CHI", 1993, 40, 2, 1, 20, 39, 0.4, 20);
		dm.addPlayer("lebron", "CHI", 1997, 40, 2, 1, 20, 39, 0.4, 20);
		dm.addPlayer("Pepe", "CHI", 1997, 40, 2, 1, 20, 39, 0.4, 20);
	}

	@Test
	public void test2() {
		setUpEscenary1();
		boolean x = false;
		if (dm.getListPlayer() != null) {
			x = true;
		}
		assertTrue(x);
		
	}
	public void test1() {
		setUpEscenary1();
		assertEquals("lebron", dm.searchPlayerLinearly("lebron").get(0).getName());

	}

}
