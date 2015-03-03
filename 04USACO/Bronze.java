import java.util.Random;

public class Bronze{

    private int[][]lake;

    public Bronze(){
	Random r = new Random();
	lake = new int[4][6];
	for (int i = 0; i < lake.length; i++){
	    for (int n = 0; n < lake[0].length; n++){
		lake[i][n] = r.nextInt(15) + 20;
	    }
	}
    }

    public String toString(){
	String fin = "";
	for (int i = 0; i < lake.length; i++){
	    for (int n = 0; n < lake[0].length; n++){
		if (lake[i][n] < 10){
		    fin+= " " + lake[i][n] + " ";
		}
		else{
		    fin+= lake[i][n] + " ";
		}
	    }
	    fin += "\n";
	}
	return fin;
    }

    public void instructions(int x, int y, int depth){
	int max = 0;
	for (int i = x; i < x+3; i++){
	    for (int n = y; n < y + 3; n++){
		if (lake[i][n] > max){
		    max = lake[i][n];
		}
	    }
	}
	max-= depth;
	for (int i = x; i < y+3; i++){
	    for (int n = y; n < x+3; n++){
		if (lake[i][n] > max){
		    lake[i][n] = max;
		}
	    }
	}
    }

    public int volume(int desired){
	int vol = 0;
	for(int i = 0; i < lake.length; i++){
	    for(int n = 0; n < lake[i].length; n++){
		if (desired > lake[i][n]){
		    lake[i][n] = desired - lake[i][n];
		}
		else{
		    lake[i][n] = 0;
		}
		vol+= lake[i][n];
	    }
	}
	return vol*72*72;
    }

    public static void main(String[]args){
	Bronze a = new Bronze()  ;
	System.out.println(a);
	a.instructions(0,0,5);
	System.out.println(a);
	System.out.println(a.volume(25));
	System.out.println(a);
    }
}