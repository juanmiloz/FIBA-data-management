package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class PlayerTest extends TestCase{
	private Player player1;
	
	public void setUpEscenary1() {
		 player1 = new Player("michael", "CHI", 1990, 40, 2, 1, 20, 39, 0.4, 20);
	}
	@Test
	public void test1() {
		setUpEscenary1();
		assertEquals("michael",player1.getName());

	}
	@Test
	public void test2() {
		setUpEscenary1();
		boolean x = false;
		if (player1 != null) {
			x = true;
		}
		assertTrue(x);
		
	}
	

}
