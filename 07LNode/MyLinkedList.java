public class MyLinkedList{
    private LNode head;
    private LNode last;
    private LNode current;
    private int size;


    public String toString(){
	String ans = "[ ";
	LNode temp = head;
	while(temp != null){
	    ans+=temp.getValue() +", ";
	    temp = temp.getNext();
	}
	return ans.substring(0,ans.length()-1)+"]";
    }

    public void setLast(){
	LNode temp = head;
	try{
	  
	while(temp.getNext() != null){
	    temp.setNext(temp.getNext().getNext());
	}
	last = temp.getNext();
	    }catch(IndexOutOfBoundsException e){
	    last = temp;
	}
    }

    public boolean add(int x){//not all lists have enough capacity may return false
	try{
	    last.setValue(x);
	    size +=1;
	    return true;
	}catch(IndexOutOfBoundsException e){
	    return false;
	}
    }

    public boolean remove(int index){
	
    }

    public int size(){
	return size;
    }
}