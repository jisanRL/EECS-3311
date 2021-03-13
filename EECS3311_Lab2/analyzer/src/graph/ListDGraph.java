package graph;
import java.util.ArrayList;
import java.util.LinkedList;

import util.Message;

/**
 * Use LinkedList to implement the directed graph
 * @param <V>
 * @author wangs and farhan
 */
public class ListDGraph<V> implements DGraph<V>{
   
    /**list of the vertices in a graph*/
    private LinkedList<Vertex<V>> vList;
    
    /**
     * constructor
     */
    public ListDGraph() {
        vList = new LinkedList<Vertex<V>>();
    }
    
    @Override
    public int addV(V v) {
      /**
       * TODO: implement the addV function;
       */
    	Message msg;
    	int cnt = -1;
    	v = (V) new Vertex<>(v);
    	
    	// go through the vList and check for the presence of vertex
    	for (int i = 0; i < vList.size(); i++) {
			if (vList.get(i).getV() == ((Vertex<V>) v).getV()) {
				msg = Message.M2;
				return cnt;
			}
		}
    	vList.add((Vertex<V>) v);				// if add vertex to vList 
    	cnt = vList.indexOf(v)+1;				// get the indexOf the vertex 
    	
//    	System.out.println("vList = " + vList);
//    	System.out.println("cnt = " + cnt);
        
    	return cnt;
    }
   
    
    @Override
    public boolean addE(Edge<V> e) {			
    	/**
        * TODO: implement the addE function;
        */
    	Message msg;
    	boolean checker = false;
    	
    	for (int i = 0; i < vList.size(); i++) {
			if (!(vList.get(i).getV().equals(e.getSource())) || !(vList.get(i).getV().equals(e.getDest()))) {
				msg = Message.M5;
				System.out.println(msg);
				return checker;
			}
			// check of the edge exists 
			if (vList.get(i).getV() == e.getSource()) {
				for (int j = 0; j < vList.get(i).getEdgeList().size(); j++) {
					if (e.equals(vList.get(i).getEdgeList().get(j))) {
						msg = Message.M3;
						System.out.println(msg);
						return checker;
					}
				}
			}
			checker = true;
			vList.get(i).addEdge(e);
		}
    	System.out.println("vList = " + vList);
    	System.out.println("checker = " + checker);
    	
		return checker;
    }
    
    
    @Override
    public V removeV(V v) {
    	/**
         * TODO: implement the removeV function;
         */
    	Message msg;
    	boolean checker = false;
    	int ctn = 0;
    	// go through the vList to check for presence of vertex
    	for (int i = 0; i < vList.size(); i++) {
    		if (vList.get(i).getV() == v) {
				checker = true;
				ctn = i;
			}
		}
    	// if the there is no vertex present 
    	if (checker == false) {
			msg = Message.M5;
			return null;
		}
    	// remove the vertex 
    	vList.remove(ctn);
        return v;
    }

    @Override
    public Edge<V> removeE(Edge<V> e) {		
    	/**
         * TODO: implement the removeE function;
         */
		Message msg;
		
		// go through the vList to check 
		for (int i = 0; i < vList.size(); i++) {
			// check for the source
			if (vList.get(i).getV() == e.getSource()) {
				// check for the destination
				for (int j = 0; j < vList.get(i).getEdgeList().size(); j++) {
					if (vList.get(i).getEdgeList().get(j).getDest() == e.getDest()) {
						vList.get(i).getEdgeList().remove(j);			// remove the edge
					}
				}
			}
		}
		// if 'e' is not there 
		if (e.getSource() == null || e.getDest() == null) {
			msg = Message.M6;
			return null;
		}
		return e;
    }

    @Override
    public V getV(int index) {
    	/**
         * TODO: implement the getV function;
         */
    	Message msg;
    	if (index < 0 || vList.size() > index) {
			msg = Message.M4;
			return null;
		}else {
			return (V) vList.get(index);
        }
    }
   

    @Override
    public Edge<V> getE(int src, int dest) {		
    	/**
         * TODO: implement the getE function;
         */
    	Edge<V> edg = new Edge(src, dest);
    	Message msg;
    	
    	// go through the vList 
		for (Vertex<V> vertex : vList) {
			// if the edge is present
			if (edg.getSource().equals(src) && edg.getDest().equals(dest)) {
				return edg;
			} else {
				// if the edge is not in the graph
				if (edg.getSource() == null || edg.getDest() == null) {
					msg = Message.M4;
					return null;
				}
			}
		}
    	return edg;
    }

	@Override
	public ArrayList<ArrayList<V>> branches(V v) {
		/**
		 * TODO: iterate the Graph from a given vertex and return all the branches from it;
		 */
		ArrayList<ArrayList<V>> dArr = new ArrayList<ArrayList<V>>();
		ArrayList<V> sArr = new ArrayList<V>();
		
		this.branchHelper(dArr, sArr, v);
		
		for (int i = 0; i < dArr.size(); i++) {
			if (dArr.get(i).isEmpty() == true) {
				dArr.remove(i);
			}
		}
//		System.out.println("dArr = " + dArr);
//		System.out.println("sArr = " + sArr);
		
		return dArr;
	}
	
	// helper 
	private ArrayList<ArrayList<V>> branchHelper(ArrayList<ArrayList<V>> sH, ArrayList<V> tH, V vtx) {
		ArrayList<V> sp;
		tH.add(vtx);
		
		// check vList for edge
		for (int i = 0; i < vList.size(); i++) {
			if (vList.get(i).getV() == vtx) {
				for (Edge<V> v : vList.get(i).getEdgeList()) {
					sp = new ArrayList<>(tH);
					this.branchHelper(sH, sp, v.getDest());
				}
			}
		}
		sp = new ArrayList<>(tH);
		boolean chk = false;
		
		// check existance of vertex
		for (int i = 0; i < vList.size(); i++) {
			if (vList.get(i).getV() == sp.get(sp.size()-1)) {
				if (vList.get(i).getEdgeList().size() > 0) {
					chk = true;
				}
			}
		}
		if (chk) {
			sp.removeAll(sp);
		}
		sH.add(sp);
		return sH;
	}
	
    @Override
    public int [][] matrix() {
    	/**
    	 * TODO: generate the adjacency matrix of a graph;
    	 */
    	int [][] r = new int[4][4];							// the matrix
    	
    	// initialize matrix
    	for (int i = 0; i < vList.size(); i++) {			// rows
			for (int j = 0; j < vList.size(); j++) {		// columns
				r[i][j] = 0;								// values initialzed to 0
				
				// connect the vertex
				r[i][j] = 1;
				r[j][i] = 1;
			}
		}
//    	System.out.println(r.toString());
    	return r;
    }	
}