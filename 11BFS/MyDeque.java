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

    public void resize(){
	Object[] replace = new Object[size*2];
	for(int i = head; i != tail; i++){
	    if(i == ary.length){
		i = 0;
	    }
	    replace[i]=ary[i];
	}
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
	String ans = "";
	for(int i = head; i != tail; i++){
	    if(i == ary.length){
		i=0;
	    }
	    System.out.println(ary[i]);
	}
	return ans;
    }    
    public static void main(String[] args){
	MyDeque<String> MDQ = new MyDeque<String>();
	MDQ.addLast("Oranges");
	System.out.println(MDQ);
    }

}