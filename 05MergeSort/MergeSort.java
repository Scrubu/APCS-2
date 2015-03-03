public class MergeSort{

    public int[] merge(int[] a, int min, int mid, int max){
	int[]first;
	int[]second;
	for(int x = min; x<mid; x++){
	    first[x]=a[x];
	}
	for(int x = mid; x<max;x++){
	    second[x]=a[x];
	}
	return compare(first,second);
    }

    public int[] sort(int[] a){
	if(a.length == 1){
	    return a;
	}
	return merge(a,0,a.length/2,a.length);
    }

    public int[] compare(int[] a, int[] b){
	int[] result;
	for(int x = 0; x < a.length; x++){
	    if(a[x]<b[x]){
		result[x]=a[x];
	    }
	    else{
		result[x]=b[x];
	    }
	}
    }
}
