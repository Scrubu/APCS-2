import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private LNode<T> head;
    private LNode<T> last;
    private LNode<T> current;
    private int size;

    public class MyLinkedListIterator implements Iterator<T>{
	private LNode<T> now;
	public MyLinkedListIterator(LNode<T> now) {
	    this.now = now;
	}
	public boolean hasNext() {
	    return now.getNext() != null;
	}
	public T next() {
	    T value = now.getValue();
	    now = now.getNext();
	    return value;
	}
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

    public Iterator<T> iterator(){
	MyLinkedListIterator it =new MyLinkedListIterator(head);
	return  it;
    }

    public String name(){
	return "lai.kyle";
    }
    
    public MyLinkedList(){
	head = new LNode<T>();
	setLast();
	size = 0;
    }

    
    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> now = head.getNext();
	for(int i = 0;i < index;i++){
	    now = now.getNext();
	}
	return now.getValue();
    }
    public String toString(){
	String ans = "[ ";
	LNode<T> temp = head;
	while(temp != null){
	    ans+=temp.getValue() +", ";
	    temp = temp.getNext();
	}
	return ans.substring(0,ans.length()-1)+"]";
    }

    public void setLast(){
	LNode<T> temp = head;
	try{
	  
	while(temp.getNext() != null){
	    temp.setNext(temp.getNext().getNext());
	}
	last = temp.getNext();
	    }catch(IndexOutOfBoundsException e){
	    last = temp;
	}
    }

    public boolean add(T x){//not all lists have enough capacity may return false
	try{
	    if(last.getValue() ==null){
	    last.setValue(x);
	    }
	    else{
		LNode<T> now = new LNode<T>(x);
		last.setNext(now);
		size +=1;
	    }
	    return true;
	}catch(IndexOutOfBoundsException e){
	    return false;
	}
    }

    public boolean add(T x, int index){
	if(index >= size || index < 0){
	    return false;
	}
	int currentIndex = 0;
	LNode<T> newNode = new LNode<T>(x);
	LNode<T> currentNode = head;
	LNode<T> nextNode = currentNode.getNext();
	while(currentIndex != index-1){
	    currentNode = nextNode;
	    nextNode = currentNode.getNext();
	    currentIndex +=1;
	}
	currentNode.setNext(newNode);
	newNode.setNext(nextNode);
	size+=1;
	return true;
    }

    public int indexOf(T value){
	
	int currentIndex = 0;
	LNode<T> currentNode = head;
	LNode<T> nextNode = currentNode.getNext();
	while(currentIndex < size){
	    if(currentNode.getValue() != value){
		currentNode = nextNode;
		nextNode = currentNode.getNext();
		currentIndex += 1;
	    }
	    else{
		return currentIndex;
	    }
	}
	return -1;
    }

    public boolean remove(int index){
	if(index >= size || index < 0){
	    return false;
	}
	int currentIndex = 0;
	LNode<T> currentNode = head;
	LNode<T> nextNode = currentNode.getNext();
	while(currentIndex != index-1){
	    currentNode = nextNode;
	    nextNode = currentNode.getNext();
	    currentIndex += 1;
	}
	currentNode.setNext(nextNode.getNext());
	size -= 1;
	return true;
    }

    public int size(){
	return size;
    }
}
