public class Silver{

    private char[][]board;
    private int time;
    private int startx;
    private int starty;
    private int endx;
    private int endy;


    public Silver(int x, int y, int t,char[][]dirt, int r1,int c1, int r2,int c2){
	board = new char[x][y];
	time = t;
	startx= r1-1;
	starty = c1-1;
	endx = r2-1;
	endy = c2-1;
    
	for(int i = 0; i<dirt.length; i++){
	    for(int n=0; n< dirt[i].length; n++){
		board[i][n]=dirt[i][n];
	    }
	}
    }

 public String toString(){
	String ans = "\n";
	for(int x=0; x < board.length; x++){
	    for(int y=0; y < board[x].length; y++){
		ans+=board[x][y]+" ";
	    }
	    ans+="\n";
	}
		return  ans;
	//	return hide + go(0,0) + ans + "\n" + show;
    }

    public int solve(){
	return solve(startx,starty,endx,endy,time);
    }

    public int solve(int sX,int sY,int eX,int eY,int t){
	System.out.println(this);
	if(t==0){
	    if(sX==eX && sY==eY){
		return 1;
	    }
	    else{
		return 0;
	    }
	}
	char here=' ';
	try{
	    here=board[sX][sY];
	}catch(ArrayIndexOutOfBoundsException e){
	    return 0;
	}
	if(here=='*'){
	    return 0;
	}
	
	return solve(sX-1,sY,eX,eY,t-1)+
	    solve(sX+1,sY,eX,eY,t-1)+
	    solve(sX,sY+1,eX,eY,t-1)+
	    solve(sX,sY-1,eX,eY,t-1);
    }


    

       public static void main(String[]args){



	   char[][] a = { {'.','.','.','*','.'}, {'.','.','.','*','.'}, {'.','.','.','.','.'}, {'.','.','.','.','.'} };
	       	Silver c = new Silver(4, 5, 6, a, 1, 3, 1, 5);
		System.out.println(c.solve());

	}

}
    
