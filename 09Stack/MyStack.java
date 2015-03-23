public class MyStack{
    private LNode<T> stack;
    private LNode<T> end;
    public MyStack(){
	stack= new LNode();
	end = stack;
    }
    public boolean empty(){
	return stack.getValue() == null;
    }
    public void push(T x){
	if(empty()){
	    stack.setValue(x);
	}
	LNode<T> next = new LNode(x);
	end = next;
	stack.setNext(end);

    }
    public int pop(){
	if(empty()){
	    throw new EmptyStackException();
	}
	num = end.getValue();
	return num;
    }

    
}
