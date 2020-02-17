package me.atticuszambrana.omegalul.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AtticusMessageGui {
	
	private JFrame frame;
	private JPanel panel;
	private List<String> messages = new ArrayList<String>();
	private JLabel topLabel;
	private JLabel allMessages = new JLabel();
	
	public AtticusMessageGui() {
		frame = new JFrame("My Messages");
		panel = new JPanel();		
		topLabel = new JLabel("Your messages will be displayed here");
		
		//panel.add(topLabel, BorderLayout.CENTER);
		panel.add(allMessages, BorderLayout.CENTER);
		
		JScrollPane pane = new JScrollPane(panel);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		frame.add(pane);
		
		frame.add(panel);
		frame.setSize(400, 500);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		
		add("When you chat, your messages will be displayed here");
	}
	
	public void clearChat() {
		allMessages.setText("");
	}
	
	public void add(String text) {
		String old = allMessages.getText();
		messages.add(text);
		// then update all the current ones
		for(String m : messages) {
			allMessages.setText("<html>" + old + "<br>" + text + "");
		}
	}

}
