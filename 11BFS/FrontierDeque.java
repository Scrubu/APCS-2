
import java.util.*;
public class FrontierDeque{
    private Frontier[]ary;
    private int size,head,tail;
    public FrontierDeque(){
	ary = new Frontier[5];
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
    public Frontier getHead(){
	return ary[head];
    }
    public Frontier getTail(){
	return ary[tail];
    }
    public void resize(){
	Frontier[] replace = new Frontier[ary.length*2];
	int current = head;
	int index = 0;
	while(current != tail){
	    if(current == ary.length){
		current = 0;
	    }

	    if(current != tail){
		replace[index]=ary[current];
		current++;
		index++;
	    }
	}
	replace[index]=ary[tail];
	tail=index;
       	ary = replace;
    }
    public void addFirst(Frontier value){
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
    public void addLast(Frontier value){

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
    public boolean isEmpty(){
	return size==0;
    }
    public String toString(){
	String ans="";
	for(int i = 0; i < ary.length; i++){
	    ans+= " "+ary[i];


	}
	return ans;
    }

}
