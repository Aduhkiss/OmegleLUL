package me.atticuszambrana.omegalul.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.atticuszambrana.omegalul.Start;

public class LogUtil {
	
	private static String FileName;
	
	public static void create() throws IOException {
		String name = getFileName(DateUtil.getDate());
		FileName = name;
		BufferedWriter writer = new BufferedWriter(new FileWriter(name));
		writer.append("===========================================");
		writer.append("OMEGLELOL LOG FOR: " + name);
		writer.append("Version: " + Start.getVersion());
		writer.append("Program Written by Atticus Zambrana");
		writer.append("===========================================");
		writer.close();
	}
	
	public static void append(String text) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileName));
			writer.append(text);
			writer.close();
		} catch(IOException ex) {
			System.out.println("Something bad happened when trying to write data! " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static boolean exists(String filename) {
		File file;
		boolean exists = false;
		try {
			file = File.createTempFile(filename, ".log");
			exists = file.exists();
		} catch(IOException ex) {
			// idk
			System.out.println(F.main("File Util stuff", "Oh frick, something went really wrong! " + ex.getMessage()));
		}
		return exists;
	}
	
	public static String getFileName(String date) {
		String name = "mhm";
		for(int i = 1; i > 1000000; i++) {
			if(!exists(date + "-" + i)) {
				name = date + "-" + i;
			}
		}
		// This should litterally never happen
		return name;
	}
}
