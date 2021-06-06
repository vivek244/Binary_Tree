class Node 
{
    int data;
    Node left, right;
   
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
public class SumTree {
	
	 Node root;
	   
	    int toSumTree(Node node) 
	    {
	        if (node == null)
	            return 0;
	   
	        int old_val = node.data;
//	        System.out.println(old_val);
	   
	        node.data = toSumTree(node.left) + toSumTree(node.right);
//	        System.out.println(node.data);
	        return node.data + old_val;
	    }
	   
	    void printInorder(Node node) 
	    {
	        if (node == null)
	            return;
	        printInorder(node.left);
	        System.out.print(node.data + " ");
	        printInorder(node.right);
	    }

	public static void main(String[] args) {
		SumTree tree = new SumTree();
		   
        tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);
   
        tree.toSumTree(tree.root);
   
        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInorder(tree.root);

	}

}
