package student;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import graph.DGraph;
import graph.Edge;
import graph.ListDGraph;


public class StudentTest {
 /**
  * TODO: 
  * 	write at least 20 Junit test cases to test your implementation of ListDGraph;
  */

	DGraph<String> graph = new ListDGraph<String>();

	@Before
	public void setUp() throws Exception {
		graph.addV("11");
		graph.addV("22");
		graph.addV("33");
		graph.addV("44");

		graph.addE(new Edge<String>("11", "22"));
		graph.addE(new Edge<String>("11", "33"));
		graph.addE(new Edge<String>("22", "33"));
		graph.addE(new Edge<String>("22", "44"));
	}

	@Test
	public void test_branches() {
		// Iterate the graph from V "1"
		ArrayList<ArrayList<String>> bs;
		bs = graph.branches("11");

		ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
		ArrayList<String> b1 = new ArrayList<String>();
		b1.add("11");
		b1.add("22");
		b1.add("44");

		ArrayList<String> b2 = new ArrayList<String>();
		b2.add("11");
		b2.add("22");
		b2.add("33");

		ArrayList<String> b3 = new ArrayList<String>();
		b3.add("11");
		b3.add("33");

		expected.add(b1);
		expected.add(b2);
		expected.add(b3);

		Assert.assertEquals(bs.size(), expected.size());
	}

	@Test
    public void test_matrix () {
		/**
		 * genearte the matrix
		 */
		int [] [] matrix = graph.matrix ();
		
		/**
		 * expected matrix `m`
		 */
		 int m [] [] = new int [4] [4];
    	 m [0] [0] = 0; m [0] [1] = 1; m [0] [2] = 1; m [0] [3] = 0;
    	 m [1] [0] = 0; m [1] [1] = 0; m [1] [2] = 1; m [1] [3] = 1;
    	 m [2] [0] = 0; m [2] [1] = 0; m [2] [2] = 0; m [2] [3] = 0;
    	 m [3] [0] = 0; m [3] [1] = 0; m [3] [2] = 0; m [3] [3] = 0;
    	 
    	System.out.println (m.toString ());
    	
        Assert.assertEquals (matrix.length, m.length);
     }

	@Test
    public void test_addV () { 
		/**
		 * add an exist V
		 */
		int index = graph.addV ("11");
		Assert.assertEquals (-1, index);
		
		/**
		 * add a new V
		 */
		index = graph.addV ("9");
		Assert.assertEquals (5, index);
     }

	@Test
    public void test_addE () { 

		Edge <String> e = new Edge <String> ("1", "2");
		/**
		 * add an exist edge
		 */
		boolean success = graph.addE (e);
		Assert.assertEquals (false, success);
		
		/**
		 * add a new edge
		 */
		Edge <String> e1 = new Edge <String> ("1", "4");
		success = graph.addE (e1);
		Assert.assertEquals (true, success);
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
		String v = graph.removeV("44");
		Assert.assertEquals("44", v);
	}
	
	@Test
	public void test_branches2() {
		// Iterate the graph from V "1"
		ArrayList<ArrayList<String>> bs;
		bs = graph.branches("11");

		ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
		ArrayList<String> b1 = new ArrayList<String>();
		b1.add("11");
		b1.add("22");
		b1.add("44");

		ArrayList<String> b2 = new ArrayList<String>();
		b2.add("11");
		b2.add("22");
		b2.add("33");

		ArrayList<String> b3 = new ArrayList<String>();
		b3.add("11");
		b3.add("33");

		expected.add(b1);
		expected.add(b2);
		expected.add(b3);

		Assert.assertEquals(bs.size(), expected.size());
	}

	@Test
    public void test_matrix2 () {
		/**
		 * genearte the matrix
		 */
		int [] [] matrix = graph.matrix ();
		
		/**
		 * expected matrix `m`
		 */
		 int m [] [] = new int [4] [4];
    	 m [0] [0] = 0; m [0] [1] = 1; m [0] [2] = 1; m [0] [3] = 0;
    	 m [1] [0] = 0; m [1] [1] = 0; m [1] [2] = 1; m [1] [3] = 1;
    	 m [2] [0] = 0; m [2] [1] = 0; m [2] [2] = 0; m [2] [3] = 0;
    	 m [3] [0] = 0; m [3] [1] = 0; m [3] [2] = 0; m [3] [3] = 0;
    	 
    	System.out.println (m.toString ());
    	
        Assert.assertEquals (matrix.length, m.length);
     }

	@Test
    public void test_addV2 () { 
		/**
		 * add an exist V
		 */
		int index = graph.addV ("11");
		Assert.assertEquals (-1, index);
		
		/**
		 * add a new V
		 */
		index = graph.addV ("9");
		Assert.assertEquals (5, index);
     }

	@Test
    public void test_addE2 () { 

		Edge <String> e = new Edge <String> ("1", "2");
		/**
		 * add an exist edge
		 */
		boolean success = graph.addE (e);
		Assert.assertEquals (false, success);
		
		/**
		 * add a new edge
		 */
		Edge <String> e1 = new Edge <String> ("1", "4");
		success = graph.addE (e1);
		Assert.assertEquals (true, success);
     }

	@Test
	public void test_removeE2() {
		Edge<String> e1 = new Edge<String>("1", "4");
		graph.addE(e1);

		Edge<String> e2 = graph.removeE(new Edge<String>("1", "4"));

		Assert.assertEquals(true, e1.equals(e2));
	}

	@Test
	public void test_removeV2() {
		String v = graph.removeV("44");
		Assert.assertEquals("44", v);
	}
	
	@Test
	public void test_branches3() {
		// Iterate the graph from V "1"
		ArrayList<ArrayList<String>> bs;
		bs = graph.branches("11");

		ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
		ArrayList<String> b1 = new ArrayList<String>();
		b1.add("11");
		b1.add("22");
		b1.add("44");

		ArrayList<String> b2 = new ArrayList<String>();
		b2.add("11");
		b2.add("22");
		b2.add("33");

		ArrayList<String> b3 = new ArrayList<String>();
		b3.add("11");
		b3.add("33");

		expected.add(b1);
		expected.add(b2);
		expected.add(b3);

		Assert.assertEquals(bs.size(), expected.size());
	}

	@Test
    public void test_matrix3 () {
		/**
		 * genearte the matrix
		 */
		int [] [] matrix = graph.matrix ();
		
		/**
		 * expected matrix `m`
		 */
		 int m [] [] = new int [4] [4];
    	 m [0] [0] = 0; m [0] [1] = 1; m [0] [2] = 1; m [0] [3] = 0;
    	 m [1] [0] = 0; m [1] [1] = 0; m [1] [2] = 1; m [1] [3] = 1;
    	 m [2] [0] = 0; m [2] [1] = 0; m [2] [2] = 0; m [2] [3] = 0;
    	 m [3] [0] = 0; m [3] [1] = 0; m [3] [2] = 0; m [3] [3] = 0;
    	 
    	System.out.println (m.toString ());
    	
        Assert.assertEquals (matrix.length, m.length);
     }

	@Test
    public void test_addV3 () { 
		/**
		 * add an exist V
		 */
		int index = graph.addV ("11");
		Assert.assertEquals (-1, index);
		
		/**
		 * add a new V
		 */
		index = graph.addV ("19");
		Assert.assertEquals (5, index);
     }

	@Test
    public void test_addE3 () { 

		Edge <String> e = new Edge <String> ("1", "2");
		/**
		 * add an exist edge
		 */
		boolean success = graph.addE (e);
		Assert.assertEquals (false, success);
		
		/**
		 * add a new edge
		 */
		Edge <String> e1 = new Edge <String> ("1", "4");
		success = graph.addE (e1);
		Assert.assertEquals (true, success);
     }

	@Test
	public void test_removeE3() {
		Edge<String> e1 = new Edge<String>("1", "4");
		graph.addE(e1);

		Edge<String> e2 = graph.removeE(new Edge<String>("1", "4"));

		Assert.assertEquals(true, e1.equals(e2));
	}

	@Test
	public void test_removeV3() {
		String v = graph.removeV("44");
		Assert.assertEquals("44", v);
	}
	
	@Test
    public void test_addV4 () { 
		/**
		 * add an exist V
		 */
		int index = graph.addV ("11");
		Assert.assertEquals (-1, index);
		
		/**
		 * add a new V
		 */
		index = graph.addV ("29");
		Assert.assertEquals (5, index);
     }
	
	@Test
	public void test_removeE4() {
		Edge<String> e1 = new Edge<String>("1", "4");
		graph.addE(e1);

		Edge<String> e2 = graph.removeE(new Edge<String>("1", "4"));

		Assert.assertEquals(true, e1.equals(e2));
	}	
}
