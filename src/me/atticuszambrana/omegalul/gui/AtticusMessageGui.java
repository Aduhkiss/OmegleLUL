package me.atticuszambrana.omegalul.gui;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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
		
		//frame.add(pane);
		
		pane.setAutoscrolls(true);
		
		// This code will basically make it impossible to scroll up, however
		// I would rather have this, then not being able to scroll at all
		//TODO: Actually fix this bug
		pane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());
	        }
	    });
		
		frame.add(pane);
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
		try {
			messages.add(text);
		} catch(ConcurrentModificationException ex) {
		}
		// then update all the current ones
		for(String m : messages) {
			allMessages.setText("<html>" + old + "<br>" + text + "");
		}
	}

}
