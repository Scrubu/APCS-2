public class Recursion{
 
   public String name(){
	return "Lai,Kyle";
    }

    public int fact(int n){
	if(n<0){
	    throw new IllegalArgumentException("n must be positive");
	}
	if(n==0){
	    return 0;
	}
	if(n==1){
	    return 1;
	}
	else{
	    return n*fact(n-1);
	}
    }
    
    public int fib(int n){
	if(n<0){
	    throw new IllegalArgumentException("n must be positive");
	}
        return fibHelp(n,0,1);
    }

    public int fibHelp(int n, int number, int old){
	if(n == 0){
	    return number;
	}
	old = old + number;
	return fibHelp(n-1,old,number);
    }
    
    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException("n must be positive");
	}
	if(n==0){
	    return 0.0;
	}
	if(n==1){
	    return 1;
	}
	   return sqrtHelp(n,1);
    }

    public double sqrtHelp(double n, double guess){
	if(guess - ((n/guess+guess)/2) > 0 && guess - ((n/guess+guess)/2) < .0000001){
	    return guess;
	}
	guess = (n/guess+guess)/2;
	return sqrtHelp(n, guess);
    }
}
