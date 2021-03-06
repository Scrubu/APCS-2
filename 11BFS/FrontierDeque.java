
import java.util.*;
public class FrontierDeque{
    private Frontier[]ary;
    private int[]priority;
    private int size,head,tail,mode;
    private int endX,endY;
    boolean priorityDeque = false;
    public FrontierDeque(){
	ary = new Frontier[5];
	priority = new int[5];
	size = 0;
	head = 1;
	tail = 0;
    }
    public Frontier removeSmallest(){
	int minimum = priority[head];
	int minIndex= head;
	Frontier ans;
	int i= head;
	while(i!=tail){
	    if(minimum > priority[i]){
		minimum = priority[i];
		minIndex = i;
	    }
	    i++;
	    if(i >= priority.length){
		i = 0;
	    }
	}
	if(ary[tail]==ary[minIndex]){
	    ans = ary[minIndex];
	    removeTail();
	}
	else{
	ans = ary[minIndex];
	priority[minIndex]=priority[tail];
	ary[minIndex]=removeTail();
	}
	return ans;
    }
    public void setEnd(int x, int y){
	endX=x;
	endY=y;
    }
    public void setMode(int m){
	mode = m;
	if(mode > 1)
	    priorityDeque=true;
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
	if(priorityDeque){
	    replace2 = new int[priority.length*2];
	}
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
	addLast(value);
	add(p);
    }
    public void add(Frontier value){
	if(mode == 1){
	    addFirst(value);
	} else if(mode == 0){
	    addLast(value);
	} else if(mode == 2){
	    add(value,Math.abs(value.getH()-endX)+Math.abs(value.getV()-endY));
		
	} else if(mode == 3){
	    add(value,Math.abs(value.getH()-endX)+Math.abs(value.getV()-endY+value.getSize()));
	}
    }
    public void add(int value){
	if(mode == 1){
	    addFirst(value);
	}
	else{
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
    public Frontier remove(){
	if(mode<2){
	    return removeFirst();
	}
	else{
	    return removeSmallest();
	}
    }
    public Frontier removeFirst(){
	Frontier ret = ary[head];
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
	return ret;
    }
    public Frontier removeTail(){
	Frontier ret = ary[tail];
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
	return ret;
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
    public static void main(String[]args){
	FrontierDeque john = new FrontierDeque();
	Frontier a = new Frontier(0,1);
	Frontier b = new Frontier(0,2);
	Frontier c = new Frontier(27,5);
	Frontier d = new Frontier(5,2);
	Frontier e = new Frontier(2,5);
	Frontier f = new Frontier(5,2);
	Frontier g = new Frontier(2,5);
	john.setEnd(5,7);

	
	john.setMode(2);
	john.add(a,4);
	john.add(b,1);
	john.add(d,25);
	john.add(e,7);
	john.add(f,55);
	john.add(g,2);
	System.out.println(john);
	john.remove();
	System.out.println(john);
	john.remove();
	System.out.println(john);
    }
}
