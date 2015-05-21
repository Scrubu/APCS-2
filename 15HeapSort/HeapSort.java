import java.util.*;
public class HeapSort{

    public static void heapsort(int[] arr){
	if(arr.length > 1){
	    heapify(arr);
	    for(int i = arr.length-1; i >= 0; i--){
		pushSort(arr,i);
	    }
	}
    }

    //makes into heap
    public static void heapify(int[] arr){
	for(int i = arr.length-1; i >= 0; i--){
	    pushDown(arr,i);
	}
    }
    //sorts the heap
    public static void pushSort(int[]arr, int i){
	int sub = arr[0];
	arr[0]=arr[i];
	arr[i]=sub;
	for(int x = 0; x<arr.length; x++){
	    pushSort2(arr,x,i);
	}
    }
    //switches numbers if child is larger than parent 
    public static void pushSort2(int[]arr, int i, int lim){
	if(2*i+1 < lim && arr[i]<arr[2*i+1]){
	    if(2*i+2 < lim){
		if(arr[2*i+2] < arr[2*i+1]){
		    int sub = arr[i];
		    arr[i]= arr[2*i+1];
		    arr[2*i+1]= sub;
		}
		else{
		    int sub = arr[i];
		    arr[i]= arr[2*i+2];
		    arr[2*i+2]= sub;
		}
	    }
	    else{
		int sub = arr[i];
		arr[i]= arr[2*i+1];
		arr[2*i+1]= sub;
	    }
	}
	else if(2*i+2 < lim && arr[i]<arr[2*i+2]){
	    int sub = arr[i];
	    arr[i]= arr[2*i+2];
	    arr[2*i+2]= sub;
	}
    }
    //heapifier helper
    public static void pushDown(int[]arr,int i){
	    if(i%2== 1 && i/2-1 > 0 && arr[i] > arr[i/2-1]){
		int sub = arr[i/2-1];
		arr[i/2-1] = arr[i];
		arr[i] = sub;
	    }
	    if(i/2 < arr.length && arr[i] > arr[i/2]){
		int sub = arr[i/2];
		arr[i/2] = arr[i];
		arr[i] = sub;
	    }
	    System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String[]args){
	int[] n = {100};
	System.out.println(Arrays.toString(n));
	HeapSort.heapsort(n);
	System.out.println(Arrays.toString(n));
    }
}   

