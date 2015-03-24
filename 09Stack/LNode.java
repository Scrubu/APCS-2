public class LNode<T>{
    private LNode<T> next;
    private T value;

    public String name(){
	return "lai.kyle";
    }

    public LNode(){
	this(null);
    }

    public LNode(T number){
	this(number, null);
    }
    //first parameter is the value of the node
    //second is the next LNode it is linked to 
    public LNode(T number, LNode<T> nex){
	value=number;
	next=nex;
    }

    public String toString(){
	String ans=""+value;
	return ans;
    }
 
    public void setNext(LNode<T> n){
	next = n;
    }
    public void setValue(T num){
	value = num;
    }
    public T getValue(){
	return value;
    }
    public LNode<T> getNext(){
	return next;
    }

}
