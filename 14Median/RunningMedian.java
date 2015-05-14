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
	if((larger.size()+smaller.size())%2==0)
	    return (double)(larger.getRoot()+smaller.getRoot())/2;
	if(larger.size()>smaller.size()){
	    return (double)larger.getRoot();
	}
	else{
	    return (double)smaller.getRoot();
	}
    }
    public static void main(String[]args){
	RunningMedian john = new RunningMedian();
	john.add(5);
	john.add(10);
	john.add(4);
	System.out.println(john.getMedian());
    }
}
