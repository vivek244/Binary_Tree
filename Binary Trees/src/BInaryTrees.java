
class Node{
	int data; Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}

public class BInaryTrees {
	static Node root;
	 public BInaryTrees()
	    {
	        root = null;
	    }
	 
	static void print() {
		int n=height(root);
		for(int i=1;i<=n;i++)
			pgl(root,i);
	}
	
	void reverse() {
		int n=height(root);
		for(int i=n;i>=1;i--)
			pgl(root,i);
	}
	
	static int height(Node root) {
		if(root==null)
			return 0;
		else {
			int lheight=height(root.left);
			int rheight=height(root.right);
			
			return 1 + Math.max(lheight, rheight);
		}
	}
	
	static int diameter(Node root) {
		if(root ==null)
			return 0;
		int lheight=height(root.left);
		int rheight=height(root.right);
		
		int ldiameter=diameter(root.left);
		int rdiameter=diameter(root.right);
		
		return Math.max(lheight+rheight+1 ,Math.max(ldiameter, rdiameter));
	}
	
	static void pgl(Node root,int i) {
		if(root==null) return ;
		if(i==1) System.out.print(root.data + " ");
		
		else if(i>1){
			pgl(root.left,i-1);
			pgl(root.right,i-1);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BInaryTrees tree=new BInaryTrees();
		root=new Node(1);
		root.left=new Node(2);
		root.right= new Node(3);
	    root.left.left= new Node(4);
	    root.left.right= new Node(5);
	    
	    System.out.println("Level order traversal of binary tree is ");
	    print();
	    System.out.println();
	    System.out.println("Reverse binary tree is ");
	    tree.reverse();
	    System.out.println();
	    System.out.println("Height of binary tree is");
	    System.out.println(height(root));
	    System.out.println("Diameter of binary tree is ");
	    System.out.println(diameter(root));
	}

}
