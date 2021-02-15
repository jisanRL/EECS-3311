package util;
/**
 * @author wangs
 * @desc util functions for printing
 */
public class Utils {

    public static void log(Object t) {
        System.out.println(t);
    }
    
    public static void log(Message m, Object appdex) {
        System.out.println(m +" "+ appdex);
    }
    
    public static void log(String format, Object... args) {
        String str = String.format(format, args);
        System.out.println(str);
    }
}