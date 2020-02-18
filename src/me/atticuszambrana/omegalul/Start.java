package me.atticuszambrana.omegalul;

import org.nikki.omegle.Omegle;

import me.atticuszambrana.omegalul.common.util.StringUtil;
import me.atticuszambrana.omegalul.gui.AtticusGui;
import me.atticuszambrana.omegalul.gui.AtticusMessageGui;

public class Start {
	
	private final static String myVersion = "0.1.2";
	
	private static Omegle omegle;
	private static AtticusGui gui;
	private static boolean saveLogs;

	public static void main(String[] args) {
		
		// Combine all the arguments that were passed in
		String arguments = StringUtil.combine(args, 0);
		
		// Then look through all of them to see if we can find the flags we want
		if(arguments.indexOf("--save-logs") >=0) {
			saveLogs = true;
		}
		
		// Any things that we want to do before the program actually starts up, to initialize?
		
		omegle = new Omegle();
		
		// Nope, just start the program
		System.out.println("OMEGLELUL - Omegle Chat Client [" + "Version " + myVersion + "]");
		System.out.println("(C) 2020 Atticus Zambrana. All Rights Reserved.");
		
		// Initialize the new Gui that I am working on
		gui = new AtticusGui(true, new AtticusMessageGui());
	}
	
	public static Omegle getOmegle() {
		return omegle;
	}
	
	public static AtticusGui getGui() {
		return gui;
	}
	
	public static boolean saveLogs() {
		return saveLogs;
	}
	
	public static String getVersion() {
		return myVersion;
	}

}
