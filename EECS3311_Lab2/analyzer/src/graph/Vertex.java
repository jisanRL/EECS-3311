package graph;

import java.util.LinkedList;
import java.util.List;

import util.Message;

/**
 * The vertex class; a Vertex object has a vertex and a list of edges started from it;
 * @author wangs and you
 * @param <V> 
 */
public class Vertex<V> {
	
	/**vertex */
    private V v;
    
    /** edges started from this vertex*/
    private List<Edge<V>> edgeList;
    
    /**
     * constructor
     * @param v
     */
    public Vertex(V v) {
        this.v = v;
        this.edgeList = new LinkedList<Edge<V>>();
    }
    
    public V getV() {
		return v;
	}

	public List<Edge<V>> getEdgeList() {
		return edgeList;
	}

	/**
     * add an edge to the edge list of this vertex.
     * if add successfully return true;
     * if edge exists: print `M3` and return false;
     * if `e`'s src is not this vertex: print `M5` and return false;
     * @param e
     */
    public boolean addEdge(Edge<V> e) {    // check
       /**
        * TODO: add an edge to the edge list;
        */
    	// implement addE 
//    	boolean exist = false;
    	Message msg;
    	if (edgeList == null) {
			msg = Message.M5;
			return false;
		} else {
			edgeList.add(new Edge(v, e));
			msg = Message.M3;
//			exist = true;
			return true;
		}
//    	return false;
    }
    
    /**
     * get an edge between this vertex and the destination V "dest";
     * if 'dest' does not exist: print `M5` and return null; 
     * if edge does not exist: print `M6` and return null; 
     * @param dest
     * @return 
     */
    public Edge<V> getEdge(V dest) {   // check
    	/**
         * TODO: get the edge between this vertex and the destination V "dest";
         */
    	// implement getE 
    	Message msg;
    	Edge<V> edge = edgeList.get(0);
    	if (v == null && dest == null) {
			msg = Message.M5;
			return null;
		} else if(getEdgeList() == null) {
			msg = Message.M6;
			return null;
		} else {
			
		}
     	return edge;
    }
    
    /**
     * remove an edge from the edge list of this vertex
     * if 'dest' exists return the removed edge;
     * if 'dest' does not exist: print `M5` and return null; 
     * if edge does not exist: print `M6` and return null; 
     * @param dest
     * @return removed Edge<V>
     */
    public Edge<V> removeEdge(V dest) {				// edge
    	/**
         * TODO: removed an edge
         */
    	// implement remove
    	boolean xf = false; 
    	Message msg;
    	Edge<V> removedEdge = edgeList.get(1);
    	if (dest == null) {
    		msg= Message.M5;
			return null;
		} else if(this.getEdge(dest) == null) {
			msg = Message.M6;
			return null;
		} else {
			
		}
    	return removedEdge;	
    }

    public boolean equals(Vertex<V> o) {     // check
		/**
		 * TODO: implement the comparison between two vertices
		 * IFF `v` and `edgeList` are the same return true
		 */
    	if (o == edgeList && o == v || v == edgeList) {
			return true;
		}
		return false;
	}
    
    @Override
    public String toString() {
        String ret = String.format("v : %s , edges: %s", v, edgeList.toString());
        return ret;
    }    
}