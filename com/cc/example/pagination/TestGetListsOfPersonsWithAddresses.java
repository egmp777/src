package com.cc.example.pagination;

import junit.framework.TestCase;

public class TestGetListsOfPersonsWithAddresses extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testGetListsOfPersonsWithAddresses() {
		//fail("Not yet implemented"); // TODO
		
		CreateEntity handler = new CreateEntity();
		assertEquals(2, handler.getListsOfPersonsWithAddresses().size());
	    //assertEquals(1, handler.getListsOfAddresses().size());
	}

}
