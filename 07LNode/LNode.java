public class LNode{
    private LNode next;
    private int value;


    public void setNext(LNode n){
	next = n;
    }
    public void setValue(int num){
	value = num;
    }
    public int getValue(){
	return value;
    }
    public int getNext(){
	return next;
    }
}
