import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;
 
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class LCA {
	static Node node;
	private static List<Integer> path1=new ArrayList<>();
	private static List<Integer> path2=new ArrayList<>();
	
	static int find(int n1,int n2) {
		path1.clear();
		path2.clear();
		return Lca(node,n1,n2);
	}
	
	public static int Lca(Node node,int n1,int n2) {
		 if (!findPath(node, n1, path1) || !findPath(node, n2, path2)) {
	            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
	            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
	            return -1;
	        }
	 
	        int i;
	        for (i = 0; i < path1.size() && i < path2.size(); i++) {
	             
	            if (!path1.get(i).equals(path2.get(i)))
	                break;
	        }
	 
	        return path1.get(i-1);
	}
	
	public static boolean findPath(Node node,int n,List<Integer> path) {
		if(node ==null) return false;
		path.add(node.data);
		if(node.data==n) return true;
		
		if((node.left!=null) && findPath(node.left, n, path))
			return true;
		
		if((node.right!=null) && findPath(node.right, n, path))
			return true;
		
		path.remove(path.size()-1);
		
		return false;
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
		System.out.println(find(4,5));

	}

}
