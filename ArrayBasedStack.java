import java.util.Iterator;
import java.util.Vector;

public class ArrayBasedStack<E>implements StackInterface <E>,Iterable<E> {
	
	private E[] myArray = (E[]) new Object[10000];
	private int size = 0;
	
	public ArrayBasedStack(){
		
	}
	
	@Override
	public Iterator<E> iterator() {
		Vector<E> v = new Vector<E>();
		
		for (int i = 0; i < this.myArray.length; i++) {
			
			v.addElement(this.myArray[i]);
			
		}
		
		ElementIterator<E> myIterator = new ElementIterator<E>(v);
		
		return myIterator;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		if (e == null) {
			NullPointerException npe = new NullPointerException();
			throw npe;
		}
		
		if (this.size < myArray.length) {
			this.myArray[this.size++] = e;
		}

	}

	@Override
	public E peek() {
		
		if (!isEmpty()) {
		return this.myArray[this.size - 1];
		}
		else {
			return null;
		}
	}

	@Override
	public E pop() {
		if (!isEmpty()) {
			E temp = this.myArray[this.size - 1];
			this.myArray[this.size - 1] = null;
			this.size--;
			
			return temp;
			}
			else {
				return null;
			}
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.myArray.length; i++) {
			this.myArray[i] = null;

		}
		this.size = 0;
		
	}

		//this.myArray = (E[]) new Object[10000];		
	//	this.size = 0;

	}


