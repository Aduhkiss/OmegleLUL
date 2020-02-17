package me.atticuszambrana.omegalul;

import org.nikki.omegle.Omegle;

import me.atticuszambrana.omegalul.gui.AtticusGui;
import me.atticuszambrana.omegalul.gui.AtticusMessageGui;

public class Start {
	
	private final static String myVersion = "0.0.1.1";
	
	private static Omegle omegle;
	private static AtticusGui gui;

	public static void main(String[] args) {
		
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

}
