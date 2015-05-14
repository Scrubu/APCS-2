public class RunningMedian{

    private MyHeap smaller; 
    private MyHeap larger;

    public RunningMedian(){
	smaller = MyHeap(true);
	larger = MyHeap(false);

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
	if((larger.size()+smaller.size())%2==1)
	    return (double)larger.getRoot()+smaller.getRoot()/2;
    }
}
