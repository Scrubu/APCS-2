import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> stack;
    private T value;
    public MyStack(){
	stack = new MyLinkedList<T>();
	value = stack.get(stack.size()-1);
    }
   
    public void push(T x){
	stack.add(x);
	value = stack.get(stack.size()-1);
    }
    public T pop(){
	if(stack.remove(stack.size()-1)){
	    T x = value;
	    value = stack.get(stack.size()-1);
	    return x;
	}
	    return null;
    }
    public T peek(){
	return value;
    }
    
}
