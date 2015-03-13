public class MyLinkedList{
    private LNode head;
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

    public boolean add(int x){//not all lists have enough capacity may return false
	try{
	    LNode temp = head;
	while(current.getNext() != null){
	    current.setNext(current.getNext()+1);
	}
	current.setValue(x);
	return true;
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