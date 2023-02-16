package dataStructure.linkedList;

import dataStructure.listI.ListI;

public class LinkedList<E> implements ListI<E> {
	Node<E> head;
	Node<E> tail;
	int currentSize;
	
	class Node<E> {
		Node<E> next;
		E data;
		
		public Node(E data) {
			this.next = null;
			this.data = data;
		}
	}
	
	public LinkedList() {
		head = null;
		tail = null;
		currentSize = 0;
	}

	@Override
	public void addFirst(E obj) {
		Node<E> node = new Node<>(obj);
		
		// 경계조건 1
		if(head == null) {
			head = node;
			tail = node;
			currentSize++;
			return;
		}
		
		node.next = head;
		head = node;
	
		currentSize++;
	}

	@Override
	public void addLast(E obj) {
		Node<E> node = new Node<>(obj);
		
		// 경계조건 1
		if(tail == null) {
			head = node;
			tail = node;
			currentSize++;
			return;
		} 
		
		tail.next = node;
		tail = node;
		currentSize++;
	}

	@Override
	public E removeFirst() {
		// 경계조건 1
		if(head == null) {
			return null;
		}
		
		E tmp = head.data;
		
		// 경계조건 2
		if(head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}

		currentSize--;
		
		return tmp;
	}

	@Override
	public E removeLast() {
		// 경계조건 1
		if(head == null) {
			return null;
		}
		
		// 경계조건 2
		if(head == tail) {
			return removeFirst();
		}
		
		Node<E> previous = null;
		Node<E> current = head;
		
		// current.next != null 도 가능은 하지만 NullPointerException 발생 가능성 있음
		while(current != tail) {	
			previous = current;
			current = current.next;
		}
		
		previous.next = null;
		tail = previous;
		currentSize--;
		
		return current.data;
	}

	@Override
	public E remove(E obj) {
		Node<E> previous = null;
		Node<E> current = head;
		
		// 마지막 요소까지 검사하기 위해 current.next != null 이 아닌 current != null
		while(current != null) {
			if(((Comparable<E>)obj).compareTo(current.data) == 0) {
				// 첫번째 노드를 제거해야 하는 경우
				if(current == head) {
					return removeFirst();
				}
				
				// 마지막 노드를 제거해야하는 경우 
				if(current == tail) {
					return removeLast();
				}
				
				previous.next = current.next;
				currentSize--;
				return current.data;
			}
			
			previous = current;
			current = current.next;
		}
		return null;
	}

	@Override
	public boolean contains(E obj) {
		Node<E> current = head;
		while(current != null) {
			if(((Comparable<E>)obj).compareTo(current.data) == 0) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public E peekFirst() {
		if(head == null) {
			return null;
		}

		return head.data;
	}

	@Override
	public E peekLast() {
		if(tail == null) {
			return null;
		}
		return tail.data;
	}

	
}
