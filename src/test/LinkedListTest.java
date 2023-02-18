package test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.logging.*;


import org.junit.BeforeClass;
import org.junit.Test;

import dataStructure.linkedList.LinkedList;
import dataStructure.listI.ListI;

public class LinkedListTest {
	private static Logger logger = Logger.getLogger(LinkedListTest.class.getName());
	ListI<Integer> list = new LinkedList<Integer>();
	
	@BeforeClass
	public static void setUpBeforClass() {
		// remove default log handler
        logger.setUseParentHandlers(false);

        // add new log handler
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new MyLogFormatter());
        logger.addHandler(handler);
	}

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
	
	@Test
	public void iteratorTest() {
		for(int i = 0; i < 5; i++) {
			list.addLast(i);
		}
		
		int i = 0;
		for(Integer x : list) {
			logger.info("수 : " + x);
			assertTrue(i == x);
			i++;
		}
	}
	
	public static class MyLogFormatter extends Formatter {

		private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

        @Override
        public synchronized String format(LogRecord lr) {
            return String.format(format,
                    new Date(lr.getMillis()),
                    lr.getLevel().getLocalizedName(),
                    lr.getMessage()
            );
        }
    }

}
