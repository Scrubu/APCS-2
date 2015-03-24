import java.util.*;
public class MyStack<T>{
    private MyLinkedList<T> stack;
  
    public MyStack(){
	stack = new MyLinkedList<T>();

    }
   
    public T  push(T x){
	stack.add(x,0);
	return x;
    }
    public T pop(){
	T value = stack.get(0);
	stack.remove(0);
	return value;
    }
    public T peek(){
	return stack.get(0);
    }
    
}
