import java.util.*;

public class RunningMedian{

    private MyHeap smaller; 
    private MyHeap larger;

    public RunningMedian(){
	smaller = new MyHeap(true);
	larger = new MyHeap(false);

    }

    public void add(int x){
	if(smaller.size()==0){
	    smaller.add(x);
	}
	else if(larger.size() == 0){
	    larger.add(x);
	}
	else {
	    
	}
    }

    public double getMedian(){
	if(larger.size()+smaller.size() == 0)
	    throw NoSuchElementException();
	if((larger.size()+smaller.size())%2==1)
	    return (double)larger.getRoot()+smaller.getRoot()/2;
	if(larger.size()>smaller.size()){
	    if(smaller.size()==0)
		return (double)larger.getRoot();
	    return (double)smaller.getRoot();
	}
	else{
	    if(larger.size()==0)
		return (double)smaller.getRoot();
	    return (double)larger.getRoot();
	}
    }
}
