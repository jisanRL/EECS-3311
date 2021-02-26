package graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
    public int addV(V v) { //  check
      /**
       * TODO: implement the addV function;
       */
    	Message msg;
    	int cnt = 0;
    	Vertex<V> vtx = null;
    	
    	for (Vertex<V> vertex : vList) {
			if (vList.contains((Vertex<V>)v)) {
				msg= Message.M5;
				return cnt--;
			} 
			vList.add(vtx);	
			cnt = vList.indexOf(v);
		}

        return cnt;
    }

    
    @Override
    public boolean addE(Edge<V> e) {
    	/**
        * TODO: implement the addE function;
        */
    	Message msg;
    	boolean result = false;
    	Edge<V> r = new Edge(e, e);
    	
    	
    	for (Vertex<V> vertex : vList) {
    		// edge exists if there is src and dest 
    		if (vList.contains(r.getSource()) && vList.contains(r.getDest())) {
				msg= Message.M3;
				result=true;
				return result;
			} else {
				vList.add((Vertex<V>) r.getSource());
			}
		}
    	
//        System.out.println(vList);
    	return result;
    }
    
    @Override
    public V removeV(V v) {
    	/**
         * TODO: implement the removeV function;
         */
    	Message msg;
    	Vertex<V> removedVertex=null;
    	for (Vertex<V> vertex : vList) {
			if (!vList.contains(v)) {
				msg= Message.M5;
				return null;
			} else {
				vList.remove(v);
			}
			v = (V)removedVertex;
		}
    	
        return (V) removedVertex;
    }

    @Override
    public Edge<V> removeE(Edge<V> e) {			// check
    	/**
         * TODO: implement the removeE function;
         */
    	Message msg;
    	if (e == null) {
			msg = Message.M6;
		}
    	vList.remove(e);
        return e;
    }

    @Override
    public V getV(int index) {            // check 
    	/**
         * TODO: implement the getV function;
         */
    	Message msg;
    	V vx = null; 
    	for (Vertex<V> vertex : vList) {
			if (index < 0 || index > vList.size()) {
				msg = Message.M4;
				return null;
			} else {
				vx = (V) vList.get(index);
			}
		}
//    	System.out.println(vx);
        return vx;
    }

    @Override
    public Edge<V> getE(int src, int dest) {
    	/**
         * TODO: implement the getE function;
         */
    	Edge<V> edg = new Edge(src, dest);
    	Message msg;
    	
		for (Vertex<V> vertex : vList) {
			if (edg.getSource().equals(src) && edg.getDest().equals(dest)) {
				return edg;
			} else {
				if (edg.getSource() == null || edg.getDest() == null) {
					msg = Message.M4;
					return null;
				}
			}
		}
    	return edg;
    }
	
//	
//    if(edg==null) {
//		msg = Message.M4;
//		return null;
//	}else
//	{
//		return edg;
//	}
	
	@Override
	public ArrayList<ArrayList<V>> branches(V v) {
		/**
		 * TODO: iterate the Graph from a given vertex and return all the branches from it;
		 */
		return null;
	}
	
    @Override
    public int [][] matrix() {					// check this  https://www.geeksforgeeks.org/add-and-remove-vertex-in-adjacency-matrix-representation-of-graph/
    	/**
    	 * TODO: generate the adjacency matrix of a graph;
    	 */
    	int [][] r = new int[4][4];						//	 the matrix
    	
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