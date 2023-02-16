package dataStructure.listI;

public interface ListI<E> {
	int size();
	
	void addFirst(E obj);
	void addLast(E obj);
	
	E removeFirst();
	E removeLast();
	E remove(E obj);
	
	boolean contains(E obj);
	
	E peekFirst();
	E peekLast();
}
