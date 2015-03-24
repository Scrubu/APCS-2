import java.util.*;

public class MyQueue<T>{
    private MyLinkedList<T> queue;
    
    public MyQueue(){
	queue = new MyLinkedList<T>();
    }
    public boolean enqueue(T n){
	return queue.add(n);
    }

    public T dequeue(){
	try{
	    T value = queue.get(0);
	    queue.remove(0);
	    return value;
	}catch(NoSuchElementException e){
	    return null;
	}
    }
}
