public class NQueens{
    private int[][]board;
    public String name(){
	return "lai.kyle";
    }

    public NQueens(int x){
	board = new int[x][x];
    }

    public String toString(){
	String ans="\n";
	for(int x=0; x < board.length; x++){
	    for(int y=0; y < board[x].length; y++){
		ans+= board[x][y]+" ";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    
    public boolean solve(){
	return solve(0,0,0);
    }
    
    public boolean solve(int x){
	return solve(x,x,0);
    }
    
    public void fill(int x, int y, int fillNum){
	for(int a=0; a < board.length; a++){
	    if(board[a][y]==0){
	    board[a][y]=fillNum;
	    }
	    if(board[x][a]==0){
	    board[x][a]=fillNum;
	    }
	    if(x+a<board.length && y+a<board.length){
		if(board[x+a][y+a]==0){
		    board[x+a][y+a]=fillNum;
		}
	    }
	    if(x-a >= 0 && y+a < board.length && board[x-a][y+a]==0){
		board[x-a][y+a]=fillNum;
	    }
	    if(x+a < board.length && y-a >=0 && board[x-a][y+a]==0){
		board[x-a][y+a]=fillNum;
	    }
	    if(x+a < board.length && y-a >=0 && board[x+a][y-a]==0 ){
		board[x+a][y-a]=fillNum;
	    }
	    if( x-a>=0 && y-a >= 0 && board[x-a][y-a]==0){
		board[x-a][y-a]=fillNum;
	    }
	}

    }

    public boolean checkColumn(int i){
	for(int x=0; x<board.length; x++){
	    if(board[x][i]==0){
		return true;
	    }
	}
	return false;
    }
    public void wait(int millis){
				try {
						Thread.sleep(millis);
				}
				catch (InterruptedException e) {
				}
    }
    public boolean solve(int x, int y,int numb){
	try{
	    //	System.out.println(this);
	if(numb == board.length){
	    return true;
	}
	if(x<0|| y<0 ||x >= board.length || y >= board.length){
	    return false;
	}
	if(!checkColumn(y)){
	    return false;
	}
	if(board[x][y]!=0){
	    return solve(x+1,y,numb)||solve(x-1,y,numb);
	}
	numb+=1;
	fill(x,y,numb);
	board[x][y]=numb;
	return solve(x+1,y+1,numb)||solve(x-1,y+1,numb);
	}catch(StackOverflowError e){
	    return false;
	}
    }

    /* public static void main(String[]args){
	NQueens a = new NQueens(10);
	if(a.solve()){
	System.out.println("good");
	}
	else{
	    System.out.println("bad");
	}
	}*/
}
