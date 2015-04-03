import java.util.*;
public class Frontier{
    int vertical;
    int horizontal;
    
    public Frontier(int v, int h){
	vertical = v;
	horizontal = h;
    }
    public void setH(int h){
	horizontal = h;
    }
    public void setV(int v){
	vertical = v;
    }

    public int getH(){
	return horizontal;
    }
    public int getV(){
	return vertical;
    }
}