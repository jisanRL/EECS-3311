package util;

/**
 * @author wangs
 * @desc types of statements studied in this lab
 */
public class Type {
	enum CFType {
		/**
		 * three types of control flow statements
		 */
		IF,//IF-ELSE STATEMENT
		IFRETURN,//IF-RETURN STATEMENT
		FOR,//FOR STATEMENT
		
		/**
		 * 'return' statement
		 */
		RETURN,	
	
		/**
		 * basic block
		 */
		BASIC
	  }
}
