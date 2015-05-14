import java.util.*;

public class MyHeap{

    private ArrayList<Integer> heap;
    private boolean isMax;
    
    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean max){
	heap = new ArrayList<Integer>();
	isMax = max;
    }

    public boolean compare(int index, int parentIndex){
	int val1 = heap.get(index);
	int val2 = heap.get(parentIndex);
	if(isMax){
	    return val1 > val2;
	}
	else{
	    return val1 < val2;
	}
    }

    public boolean compareMin(int index, int childIndex){
	int val1 = heap.get(index);
	int val2 = heap.get(childIndex);
	return val1 < val2;
    }
    public void pushup(int index, int parentIndex){
	int value = heap.get(index);
	heap.set(index,heap.get(parentIndex));
	heap.set(parentIndex,value);
    }
    public void add(int num){
	heap.add(num);
	int i=heap.indexOf(num);
	while(compare(i,i/2)){
	    pushup(i,i/2);
	    i = i/2;
	}
    }
    
    public void remove(){
	System.out.println(this);
	if(heap.size()==1)
	    heap.remove(0);
	if(heap.size()==2){
	    heap.remove(1);
	}
	else{
	    heap.set(1,heap.remove(heap.size()-1));
	    System.out.println(this);
	    int i = 1;
	    if(heap.size()==2){
		if(heap.get(0)<heap.get(1)){
		    int replace = heap.get(0);
		    heap.set(0,heap.get(1));
		    heap.set(1,replace);
		}
	    }
	    else{
		while((compareMin(i-1,2*i-1)) || (compareMin(i-1,2*i))){
		    if(compareMin(i,2*i-1)){
			pushup(i-1,2*i-1);
			i = 2*i-1;
			System.out.println(this);
		    }
		    else{
			if(compareMin(i-1,2*i)){
			    pushup(i-1,2*i);
			    i = 2*i;
		    
			}
			System.out.println(this);
		    }
		}
	    }
	}
    }
 
    public int size(){
	return heap.size();
    }
    public String toString(){
	return heap.toString();
    }

 public static void main(String[] args){
	MyHeap h = new MyHeap(true);
	h.add(1);
	System.out.println(h);
	h.add(51);
	System.out.println(h);
	h.add(25);
	System.out.println(h);
	h.add(4);
	System.out.println(h);
	System.out.println(h.size());
	h.remove();
System.out.println(h.size());
	h.remove();
	h.remove();
	System.out.println(h);
    }

}
