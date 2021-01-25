package york.eecs.source;

/**
 * @author song
 * @description: @MapContainsNullValueException is a customized exception, 
 * 				 which is for map that contains null values. 
 * 				 Do not modify this class!
 */
public class MapContainsNullValueException extends RuntimeException {
	public MapContainsNullValueException(String message) {
	        super(message);
	    }
}