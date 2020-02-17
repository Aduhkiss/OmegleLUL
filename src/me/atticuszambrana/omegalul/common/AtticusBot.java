package me.atticuszambrana.omegalul.common;

public abstract class AtticusBot {
	
	protected String name;
	protected String social;
	
	public AtticusBot(String name, String social) {
		this.name = name;
		this.social = social;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSocial() {
		return social;
	}
	
	public abstract String parse(String input);

}
