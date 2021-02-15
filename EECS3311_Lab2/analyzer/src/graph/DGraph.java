package graph;
import java.util.ArrayList;
/**
 * Interface class of directed Graph. Do not modify this class.
 * @author wangs
 * @param <V>
 */
public interface DGraph<V> {
    /**
     * create an object of Vertex and add it into the vertex list
     * @param v
     * @return the id of new added vertex; 
     * 		   IF the vertex exits: print message `M2` and return -1; 
     */
    public int addV(V v);

    /**
     * add an edge into the edge list of the start vertex (i.e., 'src') of this edge;
     * IF the edge exits: print message `M3` and return false;
     * IF 'src' or 'dest' of the edge is not in the graph: print message `M5` and return false;
     * @param e
     */
    public boolean addE(Edge<V> e);
    
    /**
     * remove a vertex and edges linked to it
     * @param v
     * @return the removed vertex; IF v does not exist: print message `M5` and return null; 
     */
    public V removeV(V v);
    
    /**
     * remove an edge
     * @param e
     * @return the removed edge; IF cannot find `e`: print message `M6` and return null;
     */
    public Edge<V> removeE(Edge<V> e);
    
    /**
     * get a vertex
     * @param index of the vertex
     * @return vertex V ; IF `index` is out of range: print message `M4` and return null;
     */
    public V getV(int index);
    
    /**
     * get an edge with specified source and destination;
     * @param src
     * @param dest
     * @return an edge; IF 'src' or 'dest' of the edge is not in the graph: print message `M4` and return null;
     */
    public Edge<V> getE(int src, int dest);
    
    /**
     * iterate the Graph from a given vertex and return all the branches from it
     * @param v
     * @return a list of branches; IF v does not exist: print message `M5` and return null;
     */
    public ArrayList<ArrayList<V>> branches(V v);
    
    /** generate the adjacency matrix of the Graph;
     *  values of elements are either '1' (the two Vs are connected) or '0' (no edges exist between two Vs)
     * @return
     */
    public int[][] matrix();
}