package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dataStructure.hash.HashInStr;

public class HashInStrTest {
	
	private HashInStr hashInStr = new HashInStr();
	
	@Test
	public void hashCodeTest() {
		int hash1 = hashInStr.hashCode("this");
		int hash2 = hashInStr.hashCode("itsh");
		assertTrue(hash1 != hash2);
	}

}
