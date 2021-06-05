//class Node{
//	int data;Node right,left;
//	Node(int d){
//		data=d;
//		right=left=null;
//	}
//}

class Max_level {  
    int max_level;
}

public class LeftRight_View {
	static Node root;
	static int max=0;
	static Max_level m = new Max_level();
	
	static void left(Node root,int level) {
		if(root==null) return;
		if(max<level)
			System.out.print(root.data + " ");
		max=level;
		left(root.left,level+1);
		left(root.right,level+1);
	}
	
	static void l() {
		left(root,1);
	}
	
	
	
	static void right(Node root,int level, Max_level m) {
		if(root ==null) return;
		if(m.max_level<level) 
			System.out.print(root.data + " ");
		m.max_level=level;
		right(root.right,level+1,m);
		right(root.left,level+1,m);
	}
	
	static void r() {
		right(root,1,m);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root=new Node(1);
		root.left=new Node(2);
		root.right= new Node(3);
	    root.left.left= new Node(4);
	    root.left.right= new Node(5);
	    root.left.left.left=new Node(8);
	    root.right.left= new Node(6);
	    root.right.right= new Node(8);
	    root.right.right.right= new Node(9);
	   System.out.println("Left view of a tree is:");
	    l();
	    System.out.println();
	    System.out.println("Right view of a tree is:");
	    r();

	}

}
