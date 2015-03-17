public class NQueens{
    private char[][]board;
    public String name(){
	return "lai.kyle";
    }

    public NQueens(int x){
	board = new char[x][x];
	for(int i=0; i<board.length; i++){
	    for(int y=0; y< board.length; y++){
		board[i][y]='-';
	    }
	}
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
	return solve(0);
    }
    /*  public boolean solve(int x){
	return solve(x,0,0);
	}*/
   
    public boolean czech(int x, int y){
	for(int a=0; a < board.length; a++){
	    if(board[a][y]=='q'){
		return false;
	    }
	    if(board[x][a]=='q'){
		return false;
	    }
	    if(x+a<board.length && y+a<board.length){
		if(board[x+a][y+a]=='q'){
		    return false;
		}
	    }
	    if(x-a >= 0 && y+a < board.length && board[x-a][y+a]=='q'){
		return false;
	    }
	    
	    if(x+a < board.length && y-a >=0 && board[x+a][y-a]=='q' ){
		return false;
	    }
	    if( x-a>=0 && y-a >= 0 && board[x-a][y-a]=='q'){
		return false;
	    }
	}
	return true;
    }

    public boolean checkColumn(int i,char n){
	for(int x=0; x<board.length; x++){
	    if(board[x][i]==n){
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

    public boolean checkRow(int row){
	// checks row for queen
	for(int y=0; y<board.length;y++){
	    if( board[row][y]== 'q'){
		return false;
	    }
	}
	return true;
    }

   


    public boolean solve(int column){
	//if(board[4][0]=='q'){
	//    System.out.println(this);
	//}
	if(column>=board.length){
	    return true;
	}
	// When you call solve(), you pick a column to look at
	// Then, you loop through the rows
	// You check each (column, row) for a suitable spot

	for(int x=0;x<board[column].length;x++){
	    if(czech(x,column)){
		board[x][column]='q';
		if(!solve(column+1)){
		    board[x][column]='-';
		}
		else{
		    return true;
		}
	    }
	}
	return false;
	}








    /*    public boolean solve(int x, int y,int numb){
	//	try{
	    
	    if(numb >= board.length){
	    return true;
	}
	
	if(x<0|| y<0 ||x >= board.length || y >= board.length){
	    return false;
	}
	if(board[x][y]!='-' && checkColumn(y,'-')){
	  return solve(x-1,y,numb)||solve(x+1,y,numb);
	}
	 numb+=1;
        
	board[x][y]='q';
	fill(x,y,'.');

	System.out.println(this);
	
	wait(1000);

	if(solve(x,y+1,numb)||solve(x+1,y+1,numb)||solve(x-1,y+1)){
	    return true;
	}
	else{
	    board[x][y]='-';
	    fill(x,y,'-');	     
	    return solve(x-1,y,numb)||solve(x+1,y,numb);
	}	
	//	}catch(StackOverflowError e){
	//  return false;
	//}
	}*/

     public static void main(String[]args){
	NQueens a = new NQueens(8);
	if(a.solve()){
	System.out.println("good");
	}
	else{
	    System.out.println("bad");
	}
	}
}
