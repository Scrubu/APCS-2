import java.util.Arrays;
public class MergeSort{

    

    public int[] mergeSort(int[] ar){
	if(ar.length<=1){
	    return ar;
	}
	int[] a;
	int[] b;
	if(ar.length%2==0){
	    a=new int[ar.length/2];
	    b=new int[ar.length/2];
	}
	else{
	    a=new int[ar.length/2];
	    b=new int[ar.length-(a.length)];
	}
	
	for(int i =0;i<ar.length/2;i++){
	    a[i]=ar[i];
	}
	for(int i=ar.length/2;i<ar.length;i++){
	    b[i-(ar.length/2)]=ar[i];
	}
	return merge(mergeSort(a),mergeSort(b));
    }

    public int[] merge(int[] a, int[] b){
	int[] result = new int[a.length+b.length];
	
	int i, ai, bi;
	i = ai = bi = 0;
	while(ai<a.length && bi<b.length){
	    if(a[ai] < b[bi]){
		result[i]=a[ai];
		ai++;
	    }
	    else{
		result[i]=b[bi];
		bi++;
	    }
	    i++;
	}
	if(ai < bi){
	    while(ai<a.length){
		result[i]=a[ai];
		i++;
		ai++;
	    }
	}
	else{
	    while(bi<b.length){
		result[i]=b[bi];
		i++;
		bi++;
	    }
	}  
    
    return result;
    }

   
}
