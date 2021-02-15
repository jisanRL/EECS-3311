package util;

/**
 * @author wangs
 * @desc error messages
 */
public enum Message {
	  M1 {
	      public String toString() {
	          return "Path does not exist";
	      }
	  },

	  M2 {
	      public String toString() {
	          return "Vertex already exists";
	      }
	  },
	  
	  M3 {
	      public String toString() {
	          return "Edge already exists";
	      }
	  },
	  
	  M4 {
	      public String toString() {
	          return "Index is out of range";
	      }
	  },
	  
	  M5 {
	      public String toString() {
	          return "Vertex does not exist";
	      }
	  },
	  
	  M6 {
	      public String toString() {
	          return "Edge does not exist";
	      }
	  },
}