import java.util.HashMap;

class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}


public class Max_sum {
	
	public static int sumgc(Node node,HashMap<Node,Integer> mp) {
		int sum=0;
		if(node==null)
			return 0;
		if(node.left!=null)
			sum +=adj(node.left.left,mp) + adj(node.left.right,mp);
		
		if(node.right !=null)
			sum+=adj(node.right.left,mp) +adj(node.right.right,mp);
		return sum;
	}
	
	public static int adj(Node node,HashMap<Node,Integer> mp) {
		if(node==null)
			return 0;
		if(mp.containsKey(node))
			return mp.get(node);
		
		int incl=node.data +sumgc(node,mp);
		System.out.println(incl);
		int excl=adj(node.left,mp) + adj(node.right ,mp);
		System.out.println(excl);
		mp.put(node, Math.max(incl, excl));
//		System.out.println(mp.values());
		return mp.get(node);

	}
	
	public static int getMax(Node node) {
		if(node==null)
			return 0;
		HashMap<Node,Integer> mp=new HashMap<>();
		return adj(node,mp);
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
		System.out.println(getMax(node));

	}

}
