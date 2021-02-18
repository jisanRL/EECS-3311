package graph;

/**
 * The edge class; an edge has one source vertex and one destination vertex;
 * @author wangs and farhan
 * @param <V> 
 */
public class Edge<V> {
	
    /**source of an edge*/
    private V src;
    
    /**destination of an edge*/
    private V dest;
    
    /**
     * @param src
     * @param dest
     */
    public Edge(V src, V dest) {
        this.src = src;
        this.dest = dest;
    }
    
    /**
     * get the source of this edge
     * @return
     */
    public V getSource() {
        return this.src;
    }
    
    /**
     * get the destination of this edge
     * @return
     */
    public V getDest() {
        return this.dest;
    }

    public boolean equals(Edge<V> o) {   // check
    	/**
		 * TODO: implement the comparison between two edges
		 * IFF `src` and `dest` are the same return true
		 */
    	Edge<V> myEdge = o;
    	
    	if (this.src == myEdge.src || this.dest == myEdge.dest) {
			return true;
		} else {
			return false;
		}
	}
    
    @Override
    public String toString() {
        String ret = String.format("src: %s , dest: %s", src, dest);
        return ret;
    }    
}