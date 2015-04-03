import java.util.*;
import java.io.*;
public class Maze{
    private FrontierDeque frontier;
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }


    public Maze(String filename){
	frontier = new FrontierDeque();
	startx = -1;
	starty = -1;
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
    
    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveBFS(boolean animate){
	Frontier current = new Frontier(starty, startx);
	frontier.addLast(current);
	while(!frontier.isEmpty()|| maze[frontier.getHead().getV()][frontier.getHead().getH()]=='E'){
	    System.out.println(frontier);
	    System.out.println();

	    if(valid(frontier.getHead().getV(),frontier.getHead().getH(),"up")){
		Frontier sub = new Frontier(frontier.getHead().getV(),frontier.getHead().getH());
		sub.setV(sub.getV()-1);
	
		frontier.addLast(sub);
	    }
	    
	    if(valid(frontier.getHead().getV(),frontier.getHead().getH(),"down")){
		Frontier sub = new Frontier(frontier.getHead().getV(),frontier.getHead().getH());
		sub.setV(sub.getV()+1);
	        
		frontier.addLast(sub);
	    }
	  
	    if(valid(frontier.getHead().getV(),frontier.getHead().getH(),"left")){
		Frontier sub = new Frontier(frontier.getHead().getV(),frontier.getHead().getH());
		sub.setH(sub.getH()-1);
		
		frontier.addLast(sub);
	    }
	  
	    if(valid(frontier.getHead().getV(),frontier.getHead().getH(),"right")){
		Frontier sub = new Frontier(frontier.getHead().getV(),frontier.getHead().getH());
		sub.setH(sub.getH()+1);
		
		frontier.addLast(sub);
	    }
	    if(maze[frontier.getHead().getV()][frontier.getHead().getH()]!='E'){
		maze[frontier.getHead().getV()][frontier.getHead().getH()]='*';
	    }
	    else{
		return true;
	    }
	    frontier.removeFirst();
	    if(animate){
		System.out.println(this);
	    }
	    //System.out.println(frontier.getS());
	}
	
	return false;
    }
    public int[] solutionArray(){
	int[] sol= new int[2];
	return sol;
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
	if(dicks != '#' && dicks != '*'){
	    return true;
	}
	return false;
    }
    public static void main(String[]args){
	Maze x = new Maze("data3.dat");
	System.out.println(x.solveBFS(true));
    }
}
