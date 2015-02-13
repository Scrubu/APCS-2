

import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


    //toString()terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];		
    }

    

    public void solve(){
	if(solve(0,0,1)){
	    toString();
	}			
    }


    public void solve(int startx, int starty){
	if(solve(startx,starty,1)){
		toString();
	    }
      	
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
	try{
	boolean numb=false;
	System.out.println(this);
	wait(20);
	if(x >= board[0].length || y >= board.length || board[x][y]!=0){
	    return false;
	}
	board[x][y]=currentMoveNumber;
	if(solve(x+2,y+1, currentMoveNumber+1)||solve(x+2,y-1,currentMoveNumber+1)||solve(x-2,y+1,currentMoveNumber+1)||solve(x-2,y-1,currentMoveNumber+1)){
	    return true;
	}
	else{
	    return false;
	}
	}catch(ArrayIndexOutOfBoundsException n){
	    return false;
	}
    }

}