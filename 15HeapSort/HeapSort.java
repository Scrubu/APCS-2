import java.util.*;
public class HeapSort{

    public static void heapsort(int[] arr){
	if(arr.length > 1){
	    heapify(arr);
	    for(int i = 0; i < arr.length/2; i++){
		if(i == 0){
		    if(arr[0]<arr[1]){
			while(arr[0]<arr[1] || arr[0]< arr[2]){
			    pushDown(arr, i);
			}
		    }
		    while(arr[i] < arr[2*i] || arr[i] < arr[2*i+1]){
			pushDown(arr,i);
		    }
		}
	    }
	}
    }

    public static void heapify(int[] arr){
	for(int i = 0; i < arr.length; i++){
	    pushDown(arr,i);
	}
    }

    public static void pushDown(int[]arr,int i){
	if(i == 0){
	    int sub = arr[0];
	    int x = 0;
	    if(arr[0] < arr[1]){
		sub = arr[1];
		x=1;
	    }
	    else if(arr[0]>arr[1]){
		
	    }
	    else if(arr[0] < arr[2]){
		sub = arr[2];
		x=2;
	    }
	    arr[x] = arr[0];
	    arr[0]=sub;
	}
	else if(2*i < arr.length && arr[i]<arr[2*i]){
	    int sub = arr[2*i];
	    arr[2*i] = arr[i];
	    arr[i] = sub;
	}
	if(2*i+1 < arr.length && arr[i] < arr[2*i+1]){
	    int sub = arr[2*i+1];
	    arr[2*i+1] = arr[i];
	    arr[i] = sub;
	}
    }
    public static void main(String[]args){
	int[] n = {100,101,22,1,56,5};
	System.out.println(Arrays.toString(n));
	HeapSort.heapsort(n);
	System.out.println(Arrays.toString(n));
    }
}   

