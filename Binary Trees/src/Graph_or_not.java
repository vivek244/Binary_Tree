import java.util.Iterator;
import java.util.LinkedList;


public class Graph_or_not {
	
	private int v;
	private static LinkedList<Integer> adj[];
	
	Graph_or_not(int V){
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<Integer>();
	}
	
	static void add(int v,int w) {
		adj[v].add(w); 
        adj[w].add(v);
	}
	
	boolean cyclic(int v,boolean visited[] ,int parent) {
		visited[v] = true; 
        Integer i; 
  
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
  
            if (!visited[i]) 
            { 
                if (cyclic(i, visited, v)) 
                    return true; 
            } 
   
            else if (i != parent) 
            return true; 
        } 
        return false; 
	}
	
	boolean is() {
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]=false;
		
		if(cyclic(0,visited,-1))
			return false;
		
		for(int u=0;u<v;u++) {
			if(!visited[u])
				return false;
		}
			
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph_or_not g=new Graph_or_not(5);
		add(0,1);
		add(0, 2); 
        add(0, 3); 
        add(3, 4);
        add(2,4);
        if (g.is()) 
            System.out.println("Graph is Tree"); 
        else
            System.out.println("Graph is not Tree"); 

	}

}
