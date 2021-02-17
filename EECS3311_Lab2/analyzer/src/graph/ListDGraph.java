package graph;
import java.util.ArrayList;
import java.util.Collection;
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
    public int addV(V v) { //  check
      /**
       * TODO: implement the addV function;
       */
    	Message msg;
    	if (vList.contains(v)) {
    		msg= Message.M2; 
    		return -1;
		} else {
			
		}
    	vList.add(new Vertex(v));
    	int vID = 0;
    	for (Vertex<V> vertex : vList) { 
    		vertex = vList.get(vID);
		}
    	
        return vID;
    }

    
    @Override
    public boolean addE(Edge<V> e) {
    	/**
        * TODO: implement the addE function;
        */
    	Message msg;
    	boolean stv= false;
    	if (getE(0, vList.size()) != null) {
			msg = Message.M3;
			return stv;
		} else if(getE(0,vList.size()) == null){
			msg = Message.M5;
			return stv;
		}
    	
    	vList.addAll((Collection<? extends Vertex<V>>) new Edge(0, vList.size()));
        return false;
    }
    
    @Override
    public V removeV(V v) {
    	/**
         * TODO: implement the removeV function;
         */
        return null;
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
    	if (index < 0 || index > vList.size()) {
			msg = Message.M4;
		}
        return null;
    }

    @Override
    public Edge<V> getE(int src, int dest) {
    	/**
         * TODO: implement the getE function;
         */
    	Edge<V> edg = new Edge(src, dest);
    	Message msg;
    	if (edg == null) {
			msg = Message.M4;
			return null;
		} else {
			return edg;
		}
    }

	@Override
	public ArrayList<ArrayList<V>> branches(V v) {
		/**
		 * TODO: iterate the Graph from a given vertex and return all the branches from it;
		 */
		return null;
	}
	
    @Override
    public int [][] matrix() {
    	/**
    	 * TODO: generate the adjacency matrix of a graph;
    	 */
    	return null;
 
    }	
}