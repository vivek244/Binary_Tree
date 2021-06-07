
class Node {
    int data;
    Node left, right;
  
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class Boundary {
	
	 static void printLeaves(Node node)
	    {
	        if (node == null)
	            return;
	  
	        printLeaves(node.left);
	        if (node.left == null && node.right == null)
	            System.out.print(node.data + " ");
	        printLeaves(node.right);
	    }
	 
	 static void printBoundaryLeft(Node node)
	    {
	        if (node == null)
	            return;
	  
	        if (node.left != null) {
	
	            System.out.print(node.data + " ");
	            printBoundaryLeft(node.left);
	        }
	        else if (node.right != null) {
	            System.out.print(node.data + " ");
	            printBoundaryLeft(node.right);
	        }
	
	    }
	 
	 static void printBoundaryRight(Node node)
	    {
	        if (node == null)
	            return;
	  
	        if (node.right != null) {
	          
	            printBoundaryRight(node.right);
	            System.out.print(node.data + " ");
	        }
	        else if (node.left != null) {
	            printBoundaryRight(node.left);
	            System.out.print(node.data + " ");
	        }
	    }
	 
	 static void printBoundary(Node node)
	    {
	        if (node == null)
	            return;
	  
	        System.out.print(node.data + " ");
	        printBoundaryLeft(node.left);

	        printLeaves(node.left);
	        printLeaves(node.right);
	        printBoundaryRight(node.right);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
//        root.left = new Node(2);
        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        printBoundary(root);

	}

}
