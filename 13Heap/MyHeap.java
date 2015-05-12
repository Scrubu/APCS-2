import java.util.*;

public class MyHeap{

    private ArrayList<Integer> heap;
    private boolean isMax;

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
    public void pushup(int index, int parentIndex){
	int value = heap.get(index);
	heap.set(index,heap.get(parentIndex));
	heap.set(parentIndex,value);
    }
    public void add(int num){
	heap.add(num);
	int i=heap.getIndex(num);
	while(compare(i,i/2)){
	    pushup(i,i/2);
	    i = i/2;
	}
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
    }

}
