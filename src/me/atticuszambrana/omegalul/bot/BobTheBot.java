package me.atticuszambrana.omegalul.bot;

import me.atticuszambrana.omegalul.common.AtticusBot;

public class BobTheBot extends AtticusBot {
	
	public BobTheBot() {
		super("James", "@FluuufyAtticus on Twitter");
	}

	@Override
	public String parse(String in) {
		String input = in.toLowerCase();
		if(input.indexOf("your name")>=0) {
			return "My name is " + name + " and I am an Omegle Chat bot coded by " + getSocial() + ".";
		}
		if(input.equals("m")) {
			return "Ah, I see you are a male of the Human race. That is good to know!";
		}
		if(input.equals("f")) {
			return "Ah, I see you are a female of the Human race. That is good to know!";
		}
		if(input.startsWith("you have snap") || input.startsWith("have snap")) {
			return "Well, because I am a bot, I do not have social media, however my creator does have Snapchat. It is: thebeefsteak";
		}
		if(input.startsWith("hi") || input.startsWith("hello") || input.startsWith("hey")) {
			// Get the current time
			return "Hi there! How are you on this fine day?";
		}
		if(input.startsWith("im doing") || input.startsWith("i am doing")) {
			if(input.indexOf("im doing good") >=0) {
				return "";
			}
			if(input.indexOf("im doing bad") >=0) {
				return "Oh, I am sorry to hear that. Hopefully you feel better soon.";
			}
		}
		if(input.startsWith("are you a bot") || input.startsWith("are u a bot") || input.startsWith("r u a bot") || input.startsWith("you are a bot")) {
			return "Yes, Infact like I said in my opening statement, I am infact a chatbot, written by " + getSocial() + ".";
		}
		
		return "I am sorry, my code has not yet learned how to respond to this.";
	}

}
