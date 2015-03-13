public class LNode{
    private LNode next;
    private int value;


    public String toString(){
	String ans="";
	return ans;
    }
 
    public void setNext(LNode n){
	next = n;
    }
    public void setValue(int num){
	value = num;
    }
    public int getValue(){
	return value;
    }
    public LNode getNext(){
	return next;
    }

}
