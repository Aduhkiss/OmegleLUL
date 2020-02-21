package me.atticuszambrana.omegalul.common;

import javax.swing.JLabel;

import me.atticuszambrana.omegalul.common.util.Scroller;

public class Title {
	
	private JLabel label;
	private Scroller scroller;
	
	public Title(JLabel label, Scroller scroller) {
		this.label = label;
		this.scroller = scroller;
		update();
	}
	
	private void update() {
		new Thread() {
			public void run() {
				try {
					Thread.sleep(430);
				} catch (InterruptedException e) {}
				
				// Update the text
				label.setText(scroller.next());
				
				update();
			}
		}.start();
	}
	
	public JLabel getLabel() {
		return label;
	}
}
