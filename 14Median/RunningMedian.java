import java.util.*;

public class RunningMedian{

    private MyHeap smaller; 
    private MyHeap larger;

    public RunningMedian(){
	smaller = new MyHeap(true);
	larger = new MyHeap(false);

    }

    public void add(int x){
	if(smaller.size()==0)
	    smaller.add(x);
	else if(x > smaller.getRoot())
	    larger.add(x);
	else
	    smaller.add(x);
	shift();
    }

    public void shift(){
	if(larger.size()-smaller.size() >= 2){
	    int shiftNum = larger.getRoot();
	    larger.remove();
	    smaller.add(shiftNum);
	}
	else if(smaller.size()-larger.size() >= 2){
	    int shiftNum = smaller.getRoot();
	    smaller.remove();
	    larger.add(shiftNum);
	}
    }

    public double getMedian(){
	if(larger.size()+smaller.size() == 0)
	    throw new NoSuchElementException();
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
