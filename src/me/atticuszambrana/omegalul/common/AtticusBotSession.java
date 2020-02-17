package me.atticuszambrana.omegalul.common;

import org.nikki.omegle.core.OmegleException;
import org.nikki.omegle.core.OmegleMode;
import org.nikki.omegle.core.OmegleSession;
import org.nikki.omegle.event.OmegleEventAdaptor;

import me.atticuszambrana.omegalul.Start;
import me.atticuszambrana.omegalul.bot.BobTheBot;

public class AtticusBotSession {
	
	private String name;
	private int id;
	
	private boolean alive;
	
	private OmegleSession session;
	
	private AtticusBot bot;
	
	public void disconnect() {
		try {
			session.disconnect();
		} catch (OmegleException e) {
			// TODO Auto-generated catch block
			Start.getGui().getMessageGui().add("An error has occured while attempting to disconnect: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void create() {
		
		bot = new BobTheBot();
		
		try {
			session = Start.getOmegle().openSession(OmegleMode.NORMAL, new OmegleEventAdaptor() {
				@Override
				public void chatWaiting(OmegleSession session) {
					System.out.println("Waiting for chat...");
					Start.getGui().getMessageGui().add("Waiting for chat...");
				}
				@Override
				public void chatConnected(OmegleSession session) {
					System.out.println("You are now talking to a random stranger!");
					Start.getGui().getMessageGui().add("You are now talking to a random stranger!");
					
					// BOT CODE
					try {
						session.send(bot.parse("what is your name"));
					} catch (OmegleException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					alive = true;
				}
				@Override
				public void chatMessage(OmegleSession session, String message) {
					System.out.println("Stranger: " + message);
					Start.getGui().getMessageGui().add("Stranger: " + message);
					
					// BOT CODE
					try {
						session.send(bot.parse(message));
					} catch (OmegleException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				@Override
				public void messageSent(OmegleSession session, String message) {
					System.out.println("You: " + message);
					Start.getGui().getMessageGui().add("You: " + message);
				}
				@Override
				public void strangerDisconnected(OmegleSession session) {
					System.out.println("Stranger Disconnected!");
					Start.getGui().getMessageGui().add("Stranger Disconnected!");
					alive = false;
					//create();
					return;
				}
				@Override
				public void omegleError(OmegleSession session, String message) {
					System.out.println("ERROR! " + message);
					Start.getGui().getMessageGui().add("Error: " + message);
					alive = false;
					System.exit(1);
				}
			});
		} catch(OmegleException ex) {
			Start.getGui().getMessageGui().add("There was an error while connecting to the omegle server: " + ex.getMessage());
			System.out.println("Oops, something really really bad happened when trying to create the omegle session! Here is a stack trace for you to send to Atticus!");
			ex.printStackTrace();
		}
	}
	
	public void send(String message) {
		try {
			session.send(message);
		} catch (OmegleException e) {
			System.out.println("An Error occured while trying to send the message! Printing stack trace and shutting down.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void kill() {
		alive = false;
	}
}
