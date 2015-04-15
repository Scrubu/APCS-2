
import java.util.*;
public class FrontierDeque{
    private Frontier[]ary;
    private int[]priority;
    private int size,head,tail,mode;
    boolean priorityDeque = false;
    public FrontierDeque(){
	ary = new Frontier[5];
	size = 0;
	head = 1;
	tail = 0;
    }
    public void removeSmallest(){
	int minimum = priority[0];
	int minIndex= 0;
	for(int i=1; i < priority.length; i++){
	    if(minimum > priority[i]){
		minimum = priority[i];
		minIndex = i;
	    }
	    priority[minIndex]=priority[tail];
	    removeTail();
	}
    }

    public void setMode(int m){
	mode = m;
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
	int[] replace2=new int[5];
	if(priorityDeque)
	    replace2 = new int[priority.length*2];
	int current = head;
	int index = 0;
	while(current != tail){
	    if(current == ary.length){
		current = 0;
	    }

	    if(current != tail){
		replace[index]=ary[current];
		if(priorityDeque)
		    replace2[index]=priority[current];
		current++;
		index++;
	    }
	}
	head = 0;
	replace[index]=ary[tail];
	if(priorityDeque){
	    replace2[index]=priority[tail];
	    priority=replace2;
	}
	tail=index;
       	ary = replace;
    }
    public void add(Frontier value, int p){
	add(value);
	add(p);
    }
    public void add(Frontier value){
	if(mode==1){
	    addFirst(value);
	}else{
	    addLast(value);
	}
    }
    public void add(int value){
	if(mode==0){
	    addFirst(value);
	}else{
	    addLast(value);
	}
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
    
    public void addFirst(int value){
	priority[head]=value;
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
     public void addLast(int value){
	 priority[tail]=value;
     }
    public void removeFirst(){
	ary[head]=null;
	if(priorityDeque)
	    priority[head]=0;
	size--;
	if(head+1 == ary.length){
	    head = 0;
	}
	else{
	    head++;
	}
    }
    public void removeTail(){
	ary[tail]=null;
	if(priorityDeque)
	    priority[tail]=0;
	size--;
	if(tail-1 < 0){
	    tail = ary.length-1;
	}
	else{
	    tail--;
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
