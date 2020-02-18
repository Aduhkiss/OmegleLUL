package me.atticuszambrana.omegalul.common.util;

public class StringUtil {
	
	/*
	 * Utility class for working with Strings
	 * Author: Atticus Zambrana
	 */
	
	public static String removeSpaces(String message) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < message.length(); i++) {
			String c = String.valueOf(message.charAt(i));
			if(c.equals(" ")) {
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
	
	public static String[] toArray(String in) {
		return in.split(" ");
	}
	
	public static String combine(String[] arr, int startPos) {
        StringBuilder str = new StringBuilder();

        for(int i = startPos; i < arr.length; ++i) {
           str = str.append(arr[i] + " ");
        }
        return str.toString();
	}
}
