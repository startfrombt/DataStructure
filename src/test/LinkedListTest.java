package test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import dataStructure.linkedList.LinkedList;
import dataStructure.listI.ListI;

public class LinkedListTest {
	ListI<Integer> list = new LinkedList<Integer>();

	@Test
	public void addFirstTest() {
		boolean flag = true;
		int n=10;
		
		// 연결 리스트를 만듭니다.
		for(int i=0; i<n; i++) {
			list.addFirst(i); // addLast도 가능
		}
			
		// 연결 리스트를 제거합니다.
		for(int i=n-1; i>=0; i--) {
			int x = list.removeFirst(); // removeLast도 가능
			
			if(x != i) {
				flag = false;
				break;
			}
		}
			
		assertTrue(flag);
		assertTrue(list.size() == 0);
	}

}
