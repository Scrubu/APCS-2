
import java.util.*;
public class MyDeque<T>{
    private Object[]ary;
    private int size,head,tail;
    public MyDeque(){
	ary = new Object[5];
	size = 0;
	head = 1;
	tail = 0;
    }
    public int getS(){
	return size;
    }
    public int getSize(){
	return ary.length;
    }
    public Object getHead(){
	return ary[head];
    }
    public Object getTail(){
	return ary[tail];
    }
    public void resize(){
	Object[] replace = new Object[ary.length*2];
	int current = head;
	int index = 0;
	while(current != tail){
	    if(current == ary.length){
		current = 0;
	    }
	    if(current != tail){
		replace[index]=ary[current];
		index++;
		current++;
	    }
	}
	replace[index]=ary[tail];
	tail=index;
	head=0;
	ary = replace;
    }
    public void addFirst(T value){
	if(size == ary.length){
	    resize();
	}
	if(head-1 < 0){
	    head = ary.length-1;
	}
	else{
	    head--;
	}
	ary[head]=value;
	size++;
    }
    public void addLast(T value){

	if(size == ary.length){
	    resize();
	}
	if(tail+1== ary.length){
	    tail = 0;
	}
	else{
	    tail++;
	}
	ary[tail]=value;
	size++;
    }
    public void removeFirst(){
	ary[head]=null;
	size--;
	if(head+1 == ary.length){
	    head = 0;
	}
	else{
	    head++;
	}
    }
    public String toString(){
	String ans="";
	for(int i = 0; i < ary.length; i++){
	    ans+= " "+ary[i];


	}
	return ans;
    }
    public static void main(String[] args){
	MyDeque<String> MDQ = new MyDeque<String>();
	MDQ.addLast("Oranges");
	MDQ.addLast("APO");
	MDQ.addLast("pun");
	MDQ.removeFirst();
	System.out.println(MDQ);
	System.out.println(MDQ.getHead());
    }
}
