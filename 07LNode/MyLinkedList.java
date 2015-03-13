public class MyLinkedList{
    private LNode head;
    private LNode last;
    private LNode current;


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
	try{
	    LNode temp = head;
	while(temp.getNext() != null){
	    temp.setNext(temp.getNext()+1);
	}
	last = temp.getNext();
	    }catch(IndexOutofBoundsException e){
	    last = temp;
	}
    }

    public boolean add(int x){//not all lists have enough capacity may return false
	try{
	    last.setValue(x);
	}catch(IndexOutofBoundsException e){
	    return false;
	}
    }

    public int size(){
	int indexSize=0;
	LNode temp = head;
	while(temp != null){
	    indexSize+=1;
	    temp = temp.getNext();
	}
	return indexSize;
    }
}