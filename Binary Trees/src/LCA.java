
//class Node {
//    int data;
//    Node left, right;
// 
//    Node(int value) {
//        data = value;
//        left = right = null;
//    }
//}

public class LCA {
	
	public static class Node {
        int value;
        Node left;
        Node right;
 
        public Node(int value) {
            this.value = value;
        }
    }
	
	
	public static Node LCA(Node root, int n1, int n2)
    {
        if (root == null)
            return root;
        if (root.value == n1 || root.value == n2)
            return root;
 
        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);
 
        if (left != null && right != null)
            return root;
          if (left == null && right == null)
              return null;
        if (left != null)
            return LCA(root.left, n1, n2);
        else
            return LCA(root.right, n1, n2);
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node=new Node(1);
		node.left=new Node(2);
		node.right =new Node(3);
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		node.right.left =new Node(6);
		node.right.right =new Node(7);
		Node lca=LCA(node,3,4);
		System.out.println(lca.value);

	}

}


