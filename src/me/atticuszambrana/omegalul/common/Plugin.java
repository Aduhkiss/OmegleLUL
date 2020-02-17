package me.atticuszambrana.omegalul.common;

public abstract class Plugin {
	
	private String name;
	private boolean enabled;
	
	public Plugin(String name, boolean enabled) {
		this.name = name;
		this.enabled = enabled;
		if(enabled) {
			onEnable();
		}
	}
	
	public abstract void onEnable();
	
	public String getName() {
		return name;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
