package graph;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example Junit test cases for testing ListDGraph.
 * @author wangs
 *
 */
public class DGraphTest {
    DGraph<String> graph = new ListDGraph<String>();
    
    @Before
	public void setUp() throws Exception {
	 	graph.addV("1");
        graph.addV("2");
        graph.addV("3");
        graph.addV("4");
        
        graph.addE(new Edge<String>("1", "2"));
        graph.addE(new Edge<String>("1", "3"));
        graph.addE(new Edge<String>("2", "3"));
        graph.addE(new Edge<String>("2", "4"));
	}

	@Test
    public void test_branches() { 
        //Iterate the graph from V "1"
    	ArrayList<ArrayList<String>> bs;
    	bs = graph.branches("1");
        
    	ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
    	ArrayList<String> b1 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("4"); 
    	
    	ArrayList<String> b2 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("3"); 
    	
    	ArrayList<String> b3 = new ArrayList<String>();
    	b1.add("1"); b1.add("3"); 
    	
    	expected.add(b1);
    	expected.add(b2);
    	expected.add(b3);
    	
        Assert.assertEquals(bs.size(), expected.size());
     }
	
	@Test
    public void test_matrix() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */
		 int m [][] = new int[4][4];
    	 m[0][0] =0; m[0][1] =1; m[0][2] =1; m[0][3] =0;
    	 m[1][0] =0; m[1][1] =0; m[1][2] =1; m[1][3] =1;
    	 m[2][0] =0; m[2][1] =0; m[2][2] =0; m[2][3] =0;
    	 m[3][0] =0; m[3][1] =0; m[3][2] =0; m[3][3] =0;
    	 
    	System.out.println(m.toString());
    	
        Assert.assertEquals(matrix.length, m.length);
     }
	
	@Test
    public void test_addV() { 
		/**
		 * add an exist V
		 */
		int index = graph.addV("1");
		Assert.assertEquals(-1, index);
		
		/**
		 * add a new V
		 */
		index = graph.addV("9");
		Assert.assertEquals(5, index);
     }
    
	@Test
    public void test_addE() { 

		Edge<String> e = new Edge<String>("1", "2");
		/**
		 * add an exist edge
		 */
		boolean success = graph.addE(e);
		Assert.assertEquals(false, success);
		
		/**
		 * add a new edge
		 */
		Edge<String> e1 = new Edge<String>("1", "4");
		success = graph.addE(e1);
		Assert.assertEquals(true, success);
     }
	
	@Test
    public void test_removeE() { 
		Edge<String> e1 = new Edge<String>("1", "4");
		graph.addE(e1);
	
		Edge<String> e2 = graph.removeE(new Edge<String>("1", "4"));
		
        Assert.assertEquals(true, e1.equals(e2));
     }
	
	@Test
    public void test_removeV() { 
    	String v = graph.removeV("4");
        Assert.assertEquals("4", v);
     }
}