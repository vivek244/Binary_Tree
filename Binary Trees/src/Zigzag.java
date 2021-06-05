import java.util.Stack;

//class Node{
//	int data;Node left,right;
//	Node(int d){
//		this.data=d;
//	}
//}

public class Zigzag {
	static Node root;	
	static void zig(Node root) {
		if (root==null)
			return;
		Stack<Node> curr=new Stack<>();
		Stack<Node> next=new Stack<>();
		curr.push(root);
		boolean lr=true;
		
		while(!curr.isEmpty()) {
			Node node=curr.pop();
			System.out.print(node.data + " ");
			if(lr) {
				if(node.left !=null)
					next.push(node.left);
				if(node.right !=null)
					next.push(node.right);
			}
			else {
				if(node.right !=null)
					next.push(node.right);
				if(node.left !=null)
					next.push(node.left);
			}
			
			if(curr.isEmpty()) {
				lr =!lr;
				Stack<Node> temp=curr;
				curr=next;
				next=temp;
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root=new Node(1);
		root.left=new Node(2);
		root.right= new Node(3);
	    root.left.left= new Node(4);
	    root.left.right= new Node(5);
	    System.out.println("ZigZag Order traversal of binary tree is");
	    zig(root);

	}

}
