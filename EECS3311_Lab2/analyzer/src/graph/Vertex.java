package graph;

import java.util.LinkedList;
import java.util.List;

import util.Message;

/**
 * The vertex class; a Vertex object has a vertex and a list of edges started
 * from it;
 * 
 * @author wangs and farhan
 * @param <V>
 */
public class Vertex<V> {

	/** vertex */
	private V v;
	/** edges started from this vertex */
	private List<Edge<V>> edgeList;

	/**
	 * constructor
	 * 
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
	 * add an edge to the edge list of this vertex. if add successfully return true;
	 * if edge exists: print `M3` and return false; if `e`'s src is not this vertex:
	 * print `M5` and return false;
	 * 
	 * @param e
	 */
	public boolean addEdge(Edge<V> e) {
		/**
		 * TODO: add an edge to the edge list;
		 */
		Message msg;
		boolean chk = false;
		if (edgeList.contains(e)) {
			msg = Message.M3;
			return chk;
		} else if (e.getSource().equals(this.getV())) {
			msg = Message.M5;
			return chk;
		}
		edgeList.add(e);
		chk = true;
		return chk;
	}

	/**
	 * get an edge between this vertex and the destination V "dest"; if 'dest' does
	 * not exist: print `M5` and return null; if edge does not exist: print `M6` and
	 * return null;
	 * 
	 * @param dest
	 * @return
	 */
	public Edge<V> getEdge(V dest) {
		/**
		 * TODO: get the edge between this vertex and the destination V "dest";
		 */
		Message msg;
		Edge<V> edge = null;

		// go over the entire edgeList
		for (Edge<V> ed : edgeList) {
			// start from the first to last index of edgeList to get an edge
			if (this.edgeList.size() == 1) { // starting point
				// check the source and dest of the vertex
				if (this.getV() == ed.getSource() && ed.getDest() == dest) {
					edge = ed;
				}
				// check for dest
				else if (this.getV() == ed.getSource() && ed.getDest() != dest) {
					msg = Message.M5;
					return null;
				}
				// check for edges existance [if there is no src and dest there is no edge ]
				else if (this.getV() != ed.getSource() && ed.getDest() != dest) {
					msg = Message.M6;
					return null;
				} else {
				}
			} else {
				if (this.getV() == ed.getSource() && ed.getDest() == dest) {
					return ed; // get the edge
				}
			}
		}
		return edge;
	}

	/**
	 * remove an edge from the edge list of this vertex if 'dest' exists return the
	 * removed edge; if 'dest' does not exist: print `M5` and return null; if edge
	 * does not exist: print `M6` and return null;
	 * 
	 * @param dest
	 * @return removed Edge<V>
	 */
	public Edge<V> removeEdge(V dest) {
		/**
		 * TODO: removed an edge
		 */
		Message msg;
		Edge<V> removedEdge = null;

		// go over the entire edgeList
		for (Edge<V> eda : edgeList) {
			// start from the first to last index of edgeList to get an edge
			if (this.edgeList.size() == 1) {
				// remove the edge if there exists an edge [a src and dest]
				if (this.getV() == eda.getSource() && eda.getDest() == dest) {
					edgeList.remove(dest);
				}
				// if 'dest' does not exist: print `M5` and return null;
				else if (this.getV() == eda.getSource() && eda.getDest() != dest) {
					msg = Message.M5;
					return null;
				}
				// if edge does not exist: print `M6` and return null;
				else if (this.getV() != eda.getSource() && eda.getDest() != dest) {
					msg = Message.M6;
					return null;
				} else {
				}
			} else {
			}
		}
		return removedEdge;
	}

	public boolean equals(Vertex<V> o) {
		/**
		 * TODO: implement the comparison between two vertices IFF `v` and `edgeList`
		 * are the same return true
		 */
		if (this.v.getClass() == o.getClass() && this.v == o) {
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