public class TreeNode<E>{
    private TreeNode<E> left;
    private TreeNode<E> right;
    private E data;
    public TreeNode(){
	this(null);
    }
    public TreeNode(E value){
	data = value;
    }
    public void setLeft(TreeNode<E> child){
	left = child;
    }
    public void setRight(TreeNode<E> child){
	right = child;
    }
    public TreeNode<E> getLeft(){
	return left;
    }
    public TreeNode<E> getRight(){
	return right;
    }
    public E getData(){
	return data;
    }
    public String toString(){
	return ""+data;
    }
}
