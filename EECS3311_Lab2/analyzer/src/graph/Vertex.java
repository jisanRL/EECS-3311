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
    public boolean addEdge(Edge<V> e) {    // done [double check later]
       /**
        * TODO: add an edge to the edge list;
        */
    	// implement addE 
    	Message msg;
    	if (this.getV().equals((Edge<V>) e.getSource())) {
			if (edgeList.contains(e)) {
				msg = Message.M3;
				return false;
			} else if (((Edge<V>) e.getSource()).equals(this.getV())) {
				msg = Message.M5;
				return false;
			} else {}
		} else {
			edgeList.add((Edge<V>) e);
//			return true;
		}
		return true;
    }
    
    
    /**
     * get an edge between this vertex and the destination V "dest";
     * if 'dest' does not exist: print `M5` and return null; 
     * if edge does not exist: print `M6` and return null; 
     * @param dest
     * @return 
     */
    public Edge<V> getEdge(V dest) {   // double check later 
    	/**
         * TODO: get the edge between this vertex and the destination V "dest";
         */
    	// implement getE 
    	Message msg;
    	Edge<V> edge = null;
    	
    	// go over the entire edgeList 
    	for (Edge<V> ed : edgeList) {
			// start from the first to last index of edgeList to get an edge
    		if (this.edgeList.size()==1) {   									// starting point
				//check the source and dest of the vertex
    			if (this.getV() == ed.getSource() && ed.getDest() == dest) {
					edge = ed;
				} 
    			// check for dest
    			else if(this.getV() == ed.getSource() && ed.getDest() != dest) {
					msg = Message.M5;
					return null;
				} 
    			// check for edges existance [if there is no src and dest there is no edge ]
    			else if(this.getV() != ed.getSource() && ed.getDest() != dest) {
					msg = Message.M6;
					return null;
				} else {
//					if (this.getV() == ed.getSource() && ed.getDest() == dest) {
//						return ed;
//					}
				}
			} else {
				if (this.getV() == ed.getSource() && ed.getDest() == dest) {
					return ed;				// get the edge
				}
			}
		}
    	return edge;
    }
//    	if (v == null && dest == null) {
//			msg = Message.M5;
//			return null;
//		} else if(getEdgeList() == null) {
//			msg = Message.M6;
//			return null;
//		} else {
//			
//		}
    
    /**
     * remove an edge from the edge list of this vertex
     * if 'dest' exists return the removed edge;
     * if 'dest' does not exist: print `M5` and return null; 
     * if edge does not exist: print `M6` and return null; 
     * @param dest
     * @return removed Edge<V>
     */
    public Edge<V> removeEdge(V dest) {				// double check later
    	/**
         * TODO: removed an edge
         */
    	// implement remove
    	Message msg;
    	Edge<V> removedEdge = null;
    	
    	// go over the entire edgeList 
    	for (Edge<V> eda : edgeList) {
			// start from the first to last index of edgeList to get an edge
			if (this.edgeList.size()==1) {
				// remove the edge if there exists an edge [a src and dest]
				if (this.getV() == eda.getSource() && eda.getDest() == dest) {
					edgeList.remove(dest);
				}
				// if 'dest' does not exist: print `M5` and return null; 
				else if(this.getV() == eda.getSource() && eda.getDest() != dest){
					msg = Message.M5;
					return null;
				}
				// if edge does not exist: print `M6` and return null; 
				else if(this.getV() != eda.getSource() && eda.getDest() != dest) {
					msg = Message.M6;
					return null;
				} else {}
			} else {}
		}    	
    	return removedEdge;	
    }
//    	if (dest == null) {
//    		msg= Message.M5;
//			return null;
//		} else if(this.getEdge(dest) == null) {
//			msg = Message.M6;
//			return null;
//		} else {
//			
//		}   
    

    public boolean equals(Vertex<V> o) {     // double check
		/**
		 * TODO: implement the comparison between two vertices
		 * IFF `v` and `edgeList` are the same return true
		 */
    	Vertex<V> myVtx = o;
    	if (this.v == myVtx.v && this.edgeList == myVtx.edgeList) {
			return true;
		} else {
			return false;
		}
	}
    
    @Override
    public String toString() {
        String ret = String.format("v : %s , edges: %s", v, edgeList.toString());
        return ret;
    }    
}