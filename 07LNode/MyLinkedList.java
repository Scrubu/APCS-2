public class MyLinkedList{
    private LNode head;
    private LNode last;
    private LNode current;
    private int size;

    public MyLinkedList(){
	head = new LNode();
	last = head;
	size = 0;
    }



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
	LNode<T> temp = head;
	try{
	  
	while(temp.getNext() != null){
	    temp.setNext(temp.getNext().getNext());
	}
	last = temp.getNext();
	    }catch(IndexOutOfBoundsException e){
	    last = temp;
	}
    }

    public boolean add(T x){//not all lists have enough capacity may return false
	try{
	    if(last.getValue() ==null){
	    last.set(x);
	    }
	    else{
		LNode<T> now = new LNode(x);
		last.setNext(now);
		size +=1;
	    }
	    return true;
	}catch(IndexOutOfBoundsException e){
	    return false;
	}
    }

    public boolean remove(int index){
	if(index >= size || index < 0){
	    return false;
	}
	int currentIndex = 0;
	LNode<T> currentNode = head;
	LNode<T> nextNode = currentNode.getNext();
	while(currentIndex != index-1){
	    currentNode = nextNode;
	    nextNode = currentNode.getNext();
	    currentIndex += 1;
	}
	currentNode.setNext(nextNode.getNext());
	size -= 1;
    }

    public int size(){
	return size;
    }
}