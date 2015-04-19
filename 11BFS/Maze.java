import java.util.*;
import java.io.*;
public class Maze{
    private FrontierDeque frontier;
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private int endx,endy;
    int mode;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }


    public Maze(String filename){
	frontier = new FrontierDeque();
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='E'){
		endx=i%maxx;
		endy=i/maxx;
		frontier.setEnd(endx,endy);
	    }
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

 




    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return ans;
    }
    
    public String toString(boolean animate){
	if(animate){
	    String ans = ""+maxx+","+maxy+"\n";
	    for(int i=0;i<maxx*maxy;i++){
		if(i%maxx ==0 && i!=0){
		    ans+="\n";
		}
		ans += maze[i%maxx][i/maxx];
	    }	
	    return hide+go(0,0)+ans+"\n"+show;
	}
	else{
	    return toString();
	}
    }
    
    public boolean solveDFS(){
	frontier.setMode(1);
	mode = 1;
	return solve(false);
    }
    public boolean solveDFS(boolean animate){
	frontier.setMode(1);
	mode = 1;
	return solve(animate);
    }
    
    public boolean solveBFS(){
	frontier.setMode(0);
	mode = 0;
	return solve(false);
    }
    public boolean solveBFS(boolean animate){
	frontier.setMode(0);
	mode = 0;
	return solve(animate);
    }
    public boolean solveBest(){
	frontier.setMode(2);
	return solve(false);
    }
    public boolean solveA(){
	frontier.setMode(3);
	return solve(false);
    }
    public boolean solveBest(boolean animate){
	frontier.setMode(2);
	return solve(animate);
    }
    public boolean solveA(boolean animate){
	frontier.setMode(3);
	return solve(animate);
    }
    public static void delay(int x){
	try {
	    Thread.sleep(1000*x);                
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }
    public boolean solve(boolean animate){
	
	Frontier current = new Frontier(starty, startx);
	frontier.add(current);
	while(!frontier.isEmpty()&& !(maze[current.getV()][current.getH()]=='E')){
	    System.out.println(frontier);
	    System.out.println(frontier.getHead());
	    System.out.println(frontier.getTail());
	    current = frontier.remove();
	    System.out.println("dicks");
	     System.out.println(frontier);
	    System.out.println(frontier.getHead());
	    System.out.println(frontier.getTail());
	    if(valid(current.getV(),current.getH(),"up")){
		Frontier sub = new Frontier(current.getV(),current.getH());
		sub.setV(sub.getV()-1);
		sub.setP(current);
		frontier.add(sub);
	    }
	    if(valid(current.getV(),current.getH(),"down")){
		Frontier sub = new Frontier(current.getV()+1,current.getH());
		sub.setP(current);
		frontier.add(sub);
	    }
	  
	    if(valid(current.getV(),current.getH(),"left")){
		Frontier sub = new Frontier(current.getV(),current.getH()-1);
		sub.setP(current);
		frontier.add(sub);
	    }
	  
	    if(valid(current.getV(),current.getH(),"right")){
		Frontier sub = new Frontier(current.getV(),current.getH()+1);
		sub.setP(current);
		frontier.add(sub);
	    }
	    if(maze[current.getV()][current.getH()]=='E'){
		 FrontierDeque ans=new FrontierDeque();
		 Frontier p;
		 String result = "";
		 while(current.getP()!=null){
		     ans.addLast(current);
		     current=current.getP();
		 }
		 ans.addLast(current);
		 while(ans.getTail()!=null){
		     p = ans.getTail();
		     result+= "(" + p.getV() + "," + p.getH() + ")";
		     ans.removeTail();
		 }	
		 System.out.println(result);
		 return true;
	     }
	    maze[current.getV()][current.getH()]='*';
	    if(animate){
		System.out.println(frontier);
		System.out.println(this);

            }
	}
	return false;
    }




    public boolean valid(int vertical,int horizontal, String direction){
	char dicks= ' ';
	if(direction.equals("left")){
	    dicks = maze[vertical][horizontal-1];
	}
	if(direction.equals("right")){	  
	    dicks = maze[vertical][horizontal+1];
	}
	if(direction.equals("up")){
	    dicks = maze[vertical-1][horizontal];
	}
	if(direction.equals("down")){
	    dicks = maze[vertical+1][horizontal];
	}
	return dicks != '#' && dicks!='*';
    }
    public static void main(String[]args){
	Maze x = new Maze("data1.dat");
	System.out.println(x.solveBest(true));
    }
}
