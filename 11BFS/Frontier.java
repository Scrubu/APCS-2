import java.util.*;
public class Frontier{
    int vertical;
    int horizontal;

    Frontier previous;

    public Frontier(int v, int h){
	vertical = v;
	horizontal = h;
    }
    public void setP(Frontier p){
	previous = p;
    }
    public void setH(int h){
	horizontal = h;
    }
    public void setV(int v){
	vertical = v;
    }
    public Frontier  getP(){
	return previous;
    }

    public int getH(){
	return horizontal;
    }
    public int getV(){
	return vertical;
    }
    public String toString(){
	String ans = "[" + vertical + "," +horizontal +"]";
	return ans;
    }
}
