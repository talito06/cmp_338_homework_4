import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;



public class ArrayBasedQueue<E>  implements QueueInterface<E>,Iterable<E>{
	private E [] queArray = (E[]) new Object [10000];

	private int size = 0; // tracks elements in array
  
	
     public ArrayBasedQueue(){
	}
	
	
	@Override
	public Iterator<E> iterator() {
		
		Vector<E> v = new Vector<E>();
		
		 for(int i = 0; i < queArray.length; i++) {
			v.addElement(queArray[i]);
			
		}
		
    	ElementIterator<E> myIterator = new ElementIterator<E>(v);

		
    	return myIterator;

}
	@Override
	public boolean isEmpty() {
		return (this.size ==0);
	}
	@Override
	public int size() {
		return (this.size);
	}
	@Override
	public void enqueue(E e) throws IllegalStateException, NullPointerException {
		if (e == null) {
			NullPointerException npe = new NullPointerException();
			throw npe;
		}
		
		if (this.size < this.queArray.length) {
			this.queArray[this.size++] = e;
		}
			}

	@Override
	public E peek() {
		if (!isEmpty()) {
			return this.queArray[ size];
			}
			else {
				return null;
			}
	}
	@Override
	public E dequeue() {
		if (!isEmpty()) {
			E temp = this.queArray[size];
		
			for (int i = 1; i <= this.size; i++) {
				this.queArray[i-1] = this.queArray[i];	
			}
			if (this.size == this.queArray.length) {
				this.queArray[this.size - 1] = null;
			}
			this.size--;
			return temp;
			
		}else {
			return null;
			}
	}
	@Override
	public E dequeue(int index) throws NoSuchElementException {
		if (index < 0 || index >= this.size) {
			NoSuchElementException s = new NoSuchElementException();
			throw s;
		}
		if (!isEmpty()) {
			E temp = this.queArray[index];
		
			for (int i = index + 1; i <= this.size; i++) {
				this.queArray[i-1] = this.queArray[i];	
			}
			if (this.size == this.queArray.length) {
				this.queArray[this.size - 1] = null;
			}
			this.size--;
			return temp;
			
		}else {
			return null;
			}
	}


	@Override
	public void removeAll() {

		for (int i = 0; i < this.queArray.length; i++) {
			this.queArray[i] = null;

		}
		this.size = 0;
		
	}
}

    