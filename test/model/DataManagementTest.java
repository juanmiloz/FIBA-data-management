package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
	@Test
	public void test1() {
		setUpEscenary1();
		assertEquals("lebron", dm.searchPlayerLinearly("lebron").get(0).getName());

	}
	@Test
	public void test3() {
		setUpEscenary1();
		ArrayList<Player> listPlayer =  new ArrayList<>();
		listPlayer = dm.searchPlayerLinearly("lebron");
		assertEquals("CHI", listPlayer.get(0).getTeam());
	
		
	}
	@Test
    public void createBinaryTreesTest() {
        setUpEscenary1();
        assertNull(dm.getAbbTreeSTL().getRoot());
        assertNull(dm.getAvlTreeAS().getRoot());
        assertNull(dm.getAvlTreePER().getRoot());
        assertNull(dm.getAvlTreeRB().getRoot());
        assertNull(dm.getAvlTreeTS().getRoot());
        dm.createBinaryTrees();
        assertNotNull(dm.getAbbTreeSTL().getRoot());
        assertNotNull(dm.getAvlTreeAS().getRoot());
        assertNotNull(dm.getAvlTreePER().getRoot());
        assertNotNull(dm.getAvlTreeRB().getRoot());
        assertNotNull(dm.getAvlTreeTS().getRoot());
    }
	@Test
    public void filterTest() {
        setUpEscenary1();
        dm.createBinaryTrees();
        dm.filter(1.0, 2.0, 1);
        assertEquals(6, dm.getDisplayList().size());
        dm.filter(1.0, 2.0, 2);
        assertEquals(6, dm.getDisplayList().size());
        dm.filter(20.0, 21.0, 3);
        assertEquals(6, dm.getDisplayList().size());
        dm.filter(39.0, 40.0, 4);
        assertEquals(6, dm.getDisplayList().size());
        dm.filter(0.4, 0.5, 5);
        assertEquals(6, dm.getDisplayList().size());
    }

}
