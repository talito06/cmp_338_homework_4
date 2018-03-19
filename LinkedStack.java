import java.util.Iterator;
import java.util.Vector;

public class LinkedStack<E> implements StackInterface<E>,Iterable<E> {

	private Node<E> top = null;
	private Node<E> bottom = null;
	
	private int size = 0;
	
	public LinkedStack(){
	
	}
	@Override
	public Iterator<E> iterator() {
		Vector<E> v = new Vector<E>();
		Node<E> curNode = this.top;
		
		while (curNode != null) {
			v.addElement(curNode.getData());
			curNode = curNode.getNext();
		}
		
		ElementIterator<E> myIterator = new ElementIterator<E>(v);
		
		return myIterator;
	}


	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		
		if (e == null) {
			NullPointerException npe = new NullPointerException("The element e = null you BAD BAD PERSON!!!!");
			throw npe;
		}
		
		Node<E> newNode = new Node<E>(e);
		
		if (this.isEmpty()) {
			this.top = newNode;
			this.bottom = newNode;
		} else {
			newNode.setNext(this.top);
			this.top.setPrevious(newNode);
			this.top = newNode;
		}
		
		this.size++;
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.top.getData();
		}
	}

	@Override
	public E pop() {
		if (this.isEmpty()) {
			return null;
		} else {
			E data = this.top.getData();
			
			this.top = this.top.getNext();
			
			if (this.top == null) {
				this.bottom = null;
			} else {
				this.top.setPrevious(null);
			}

			this.size--;
			
			return data;
		}
	}

	@Override
	public void clear() {
		this.top = null;
		this.bottom = null;
		this.size = 0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
